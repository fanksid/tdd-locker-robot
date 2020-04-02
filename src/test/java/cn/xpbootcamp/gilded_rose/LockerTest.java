package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerTest {
    @Test
    void should_return_ticket_when_locker_lock_the_bag() throws CapacityFullException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        LockerTicket ticket = locker.save(bag);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_pick_bag_when_pick_by_the_ticket() throws NoTicketException, CapacityFullException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        LockerTicket ticket = locker.save(bag);

        Bag pickedBag = locker.pick(ticket);

        Assertions.assertSame(bag, pickedBag);
    }

    @Test()
    void should_throw_exception_when_user_pick_bag_with_no_ticket() throws CapacityFullException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        locker.save(bag);

        Assertions.assertThrows(NoTicketException.class, () -> {
            locker.pick(null);
        });
    }

    @Test
    void should_pick_the_right_bag_when_locker_has_multiple_bag_locker_given_the_ticket() throws NoTicketException, CapacityFullException {
        Locker locker = new Locker(2);
        Bag bagOne = new Bag();
        Bag bagTwo = new Bag();
        LockerTicket ticketOne = locker.save(bagOne);
        LockerTicket ticketTwo = locker.save(bagTwo);

        Bag pickedOne = locker.pick(ticketOne);
        Bag pickedTwo = locker.pick(ticketTwo);

        Assertions.assertSame(bagOne, pickedOne);
        Assertions.assertSame(bagTwo, pickedTwo);
    }

    @Test
    void should_return_null_when_pick_bag_with_invalid_ticket() throws NoTicketException, CapacityFullException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        locker.save(bag);
        LockerTicket invalidTicket = new LockerTicket();

        Bag picked = locker.pick(invalidTicket);

        Assertions.assertNull(picked);
    }

    @Test
    void should_not_return_bag_when_user_pick_bag_with_used_ticket() throws NoTicketException, CapacityFullException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        LockerTicket ticket = locker.save(bag);
        locker.pick(ticket);

        Bag picked = locker.pick(ticket);

        Assertions.assertNull(picked);
    }

    @Test
    void should_throw_exception_when_capacity_is_full() throws CapacityFullException {
        Locker locker = new Locker(1);
        locker.save(new Bag());

        Assertions.assertThrows(CapacityFullException.class, () -> {
            locker.save(new Bag());
        });
    }
}
