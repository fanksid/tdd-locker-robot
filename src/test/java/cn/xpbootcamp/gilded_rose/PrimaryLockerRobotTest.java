package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimaryLockerRobotTest {
    @Test
    void robot_should_return_ticket_and_pick_bag_with_the_ticket_given_robot_has_one_locker_when_save_and_pick() {
        Locker locker = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(locker);
        Bag bag = new Bag();
        LockerTicket ticket = robot.save(bag);

        Bag picked = robot.pick(ticket);

        Assertions.assertSame(bag, picked);
    }

    @Test
    void robot_should_return_ticket_and_pick_bag_from_first_locker_given_robot_has_two_empty_lockers_when_save() {
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
    void robot_should_return_ticket_and_pick_bag_with_the_ticket_from_2nd_given_robot_has_two_lockers_and_1st_full_when_save() {
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
    void robot_should_throw_exception_given_robot_has_one_full_locker_when_save_bag() {
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
    void robot_should_throw_exception_given_robot_has_one_locker_when_pick_with_invalid_ticket() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot(new Locker(1), new Locker(1));
        LockerTicket invalidTicket = new LockerTicket();

        Assertions.assertThrows(InvalidTicketException.class, () -> {
            robot.pick(invalidTicket);
        });
    }

    @Test
    void robot_should_throw_exception_given_robot_has_one_locker_when_pick_with_used_ticket() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot(new Locker(1), new Locker(1));
        LockerTicket ticket = robot.save(new Bag());
        robot.pick(ticket);

        Assertions.assertThrows(InvalidTicketException.class, () -> {
            robot.pick(ticket);
        });
    }
}
