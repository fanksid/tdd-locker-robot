package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerRobotTest {
    @Test
    void should_return_ticket_when_robot_lock_the_bag() {
        LockerRobot robot = new LockerRobot();
        Bag bag = new Bag();

        LockerTicket ticket = robot.lock(bag);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_pick_bag_when_pick_by_the_ticket() {
        LockerRobot robot = new LockerRobot();
        Bag bag = new Bag();
        LockerTicket ticket = robot.lock(bag);

        Bag pickedBag = robot.pick(ticket);

        Assertions.assertSame(bag, pickedBag);
    }
}
