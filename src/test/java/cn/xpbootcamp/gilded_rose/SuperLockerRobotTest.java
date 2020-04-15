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
}
