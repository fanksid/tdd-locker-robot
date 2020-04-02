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
}
