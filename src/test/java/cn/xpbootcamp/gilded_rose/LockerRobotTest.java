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
}
