package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> lockers = new ArrayList<>();

    public PrimaryLockerRobot(Locker locker) {
        this.lockers.add(locker);
    }

    public PrimaryLockerRobot(Locker... lockers) {
        this.lockers = Arrays.asList(lockers);
    }

    public LockerTicket save(Bag bag) throws CapacityFullException {
        for (Locker locker : lockers) {
            if (locker.isFull()) {
                continue;
            }
            return locker.save(bag);
        }
        return lockers.get(0).save(bag);
    }

    public Bag pick(LockerTicket ticket) throws NoTicketException {
        for (Locker locker : lockers) {
            if (locker.isIn(ticket)) {
                return locker.pick(ticket);
            }
        }
        return lockers.get(0).pick(ticket);
    }
}
