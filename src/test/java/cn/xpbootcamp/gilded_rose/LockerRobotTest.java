package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerRobotTest {
    @Test
    void should_return_ticket_when_robot_lock_the_bag() throws CapacityFullException {
        LockerRobot robot = new LockerRobot(1);
        Bag bag = new Bag();

        LockerTicket ticket = robot.save(bag);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_pick_bag_when_pick_by_the_ticket() throws NoTicketException, CapacityFullException {
        LockerRobot robot = new LockerRobot(1);
        Bag bag = new Bag();
        LockerTicket ticket = robot.save(bag);

        Bag pickedBag = robot.pick(ticket);

        Assertions.assertSame(bag, pickedBag);
    }

    @Test()
    void should_throw_exception_when_user_pick_bag_with_no_ticket() throws CapacityFullException {
        LockerRobot robot = new LockerRobot(1);
        Bag bag = new Bag();
        robot.save(bag);

        Assertions.assertThrows(NoTicketException.class, () -> {
            robot.pick(null);
        });
    }

    @Test
    void should_pick_the_right_bag_when_locker_has_multiple_bag_locker_given_the_ticket() throws NoTicketException, CapacityFullException {
        LockerRobot robot = new LockerRobot(2);
        Bag bagOne = new Bag();
        Bag bagTwo = new Bag();
        LockerTicket ticketOne = robot.save(bagOne);
        LockerTicket ticketTwo = robot.save(bagTwo);

        Bag pickedOne = robot.pick(ticketOne);
        Bag pickedTwo = robot.pick(ticketTwo);

        Assertions.assertSame(bagOne, pickedOne);
        Assertions.assertSame(bagTwo, pickedTwo);
    }

    @Test
    void should_return_null_when_pick_bag_with_invalid_ticket() throws NoTicketException, CapacityFullException {
        LockerRobot robot = new LockerRobot(1);
        Bag bag = new Bag();
        robot.save(bag);
        LockerTicket invalidTicket = new LockerTicket();

        Bag picked = robot.pick(invalidTicket);

        Assertions.assertNull(picked);
    }

    @Test
    void should_not_return_bag_when_user_pick_bag_with_used_ticket() throws NoTicketException, CapacityFullException {
        LockerRobot robot = new LockerRobot(1);
        Bag bag = new Bag();
        LockerTicket ticket = robot.save(bag);
        robot.pick(ticket);

        Bag picked = robot.pick(ticket);

        Assertions.assertNull(picked);
    }

    @Test
    void should_throw_exception_when_capacity_is_full() throws CapacityFullException {
        LockerRobot robot = new LockerRobot(1);
        robot.save(new Bag());

        Assertions.assertThrows(CapacityFullException.class, () -> {
            robot.save(new Bag());
        });
    }
}
