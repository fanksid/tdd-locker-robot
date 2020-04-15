package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SuperLockerRobotTest {

    @Test
    void should_return_ticket_and_pick_bag_given_robot_has_one_locker_when_save_and_pick() {
        Locker locker = new Locker(1);
        SuperLockerRobot robot = new SuperLockerRobot(locker);
        Bag bag = new Bag();
        LockerTicket ticket = robot.save(bag);

        Bag picked = robot.pick(ticket);

        Assertions.assertSame(bag, picked);
    }

    @Test
    void should_return_ticket_and_pick_bag_from_1st_locker_given_robot_has_two_same_space_rate_lockers_when_save() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(2);
        SuperLockerRobot robot = new SuperLockerRobot(locker1, locker2);
        Bag bag = new Bag();

        LockerTicket ticket = robot.save(bag);
        Assertions.assertSame(bag, locker1.pick(ticket));

        ticket = robot.save(bag);
        Assertions.assertSame(bag, robot.pick(ticket));
    }

    @Test
    void should_return_ticket_and_pick_bag_from_2nd_locker_given_robot_has_two_save_empty_space_rate_lockers_and_2nd_rate_is_large_when_save() {
        Locker locker1 = new Locker(2);
        locker1.save(new Bag());
        Locker locker2 = new Locker(1);
        SuperLockerRobot robot = new SuperLockerRobot(locker1, locker2);
        Bag bag = new Bag();

        LockerTicket ticket = robot.save(bag);
        Assertions.assertSame(bag, locker2.pick(ticket));

        ticket = robot.save(bag);
        Assertions.assertSame(bag, robot.pick(ticket));
    }

    @Test
    void should_return_ticket_and_pick_bag_from_2nd_locker_given_robot_has_two_lockers_and_1st_more_space_2nd_more_rate_when_save() {
        Locker locker1 = new Locker(3);
        locker1.save(new Bag());
        Locker locker2 = new Locker(1);
        SuperLockerRobot robot = new SuperLockerRobot(locker1, locker2);
        Bag bag = new Bag();

        LockerTicket ticket = robot.save(bag);
        Assertions.assertSame(bag, locker2.pick(ticket));

        ticket = robot.save(bag);
        Assertions.assertSame(bag, robot.pick(ticket));
    }

    @Test
    void should_throw_exception_given_robot_has_one_full_locker_when_save_bag() {
        Locker locker1 = new Locker(1);
        SuperLockerRobot robot = new SuperLockerRobot(locker1);
        robot.save(new Bag());

        Assertions.assertThrows(CapacityFullException.class, () -> {
            robot.save(new Bag());
        });
    }

    @Test
    void should_throw_exception_given_robot_has_one_locker_when_pick_with_invalid_ticket() {
        SuperLockerRobot robot = new SuperLockerRobot(new Locker(1));
        LockerTicket invalidTicket = new LockerTicket();

        Assertions.assertThrows(InvalidTicketException.class, () -> {
            robot.pick(invalidTicket);
        });
    }

    @Test
    void should_throw_exception_given_robot_has_one_locker_when_pick_with_used_ticket() {
        SuperLockerRobot robot = new SuperLockerRobot(new Locker(1));
        LockerTicket ticket = robot.save(new Bag());
        robot.pick(ticket);

        Assertions.assertThrows(InvalidTicketException.class, () -> {
            robot.pick(ticket);
        });
    }

}
