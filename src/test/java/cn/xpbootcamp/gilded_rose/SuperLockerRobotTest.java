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
    void should_return_ticket_and_pick_bag_from_first_locker_given_robot_has_two_same_space_rate_lockers_when_save() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(2);
        SuperLockerRobot robot = new SuperLockerRobot(locker1, locker2);
        Bag bag = new Bag();

        LockerTicket ticket = robot.save(bag);
        Assertions.assertSame(bag, locker1.pick(ticket));

        ticket = robot.save(bag);
        Assertions.assertSame(bag, robot.pick(ticket));
    }

}
