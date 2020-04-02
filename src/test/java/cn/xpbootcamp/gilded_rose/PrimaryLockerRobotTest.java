package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimaryLockerRobotTest {
    @Test
    void robot_should_return_bag_given_one_empty_locker_when_user_pick_with_ticket() throws NoTicketException, CapacityFullException {
        Locker locker = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(locker);
        Bag bag = new Bag();
        LockerTicket ticket = robot.save(bag);

        Bag picked = robot.pick(ticket);

        Assertions.assertSame(bag, picked);
    }

    @Test
    void robot_should_return_bag_from_first_locker_given_two_empty_locker_when_user_pick_bag() throws NoTicketException, CapacityFullException {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(locker1, locker2);
        Bag bag = new Bag();

        LockerTicket ticket = robot.save(bag);
        Assertions.assertSame(bag, locker1.pick(ticket));

        ticket = robot.save(bag);
        Assertions.assertSame(bag, robot.pick(ticket));
    }

    @Test
    void robot_should_return_bag_from_2nd_locker_given_two_locker_when_first_is_full() throws NoTicketException, CapacityFullException {
        Locker locker1 = new Locker(1);
        locker1.save(new Bag());
        Locker locker2 = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(locker1, locker2);
        Bag bag = new Bag();

        LockerTicket ticket = robot.save(bag);
        Assertions.assertSame(bag, locker2.pick(ticket));

        ticket = robot.save(bag);
        Assertions.assertSame(bag, robot.pick(ticket));
    }

    @Test
    void robot_should_throw_full_exception_given_two_full_locker_when_user_save_bag() throws CapacityFullException {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(locker1, locker2);
        robot.save(new Bag());
        robot.save(new Bag());

        Assertions.assertThrows(CapacityFullException.class, () -> {
            robot.save(new Bag());
        });
    }

    @Test
    void robot_should_return_null_when_user_pick_with_invalid_ticket() throws NoTicketException {
        PrimaryLockerRobot robot = new PrimaryLockerRobot(new Locker(1), new Locker(1));
        LockerTicket invalidTicket = new LockerTicket();

        Assertions.assertNull(robot.pick(invalidTicket));
    }

    @Test
    void robot_should_return_null_when_user_pick_with_used_ticket() throws NoTicketException, CapacityFullException {
        PrimaryLockerRobot robot = new PrimaryLockerRobot(new Locker(1), new Locker(1));
        LockerTicket ticket = robot.save(new Bag());
        robot.pick(ticket);

        Assertions.assertNull(robot.pick(ticket));
    }
}
