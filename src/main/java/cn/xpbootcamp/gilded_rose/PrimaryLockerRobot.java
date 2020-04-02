package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PrimaryLockerRobot {
    private List<Locker> lockers = new ArrayList<>();

    public PrimaryLockerRobot(Locker locker) {
        this.lockers.add(locker);
    }

    public PrimaryLockerRobot(Locker... lockers) {
        this.lockers = Arrays.asList(lockers);
    }

    public LockerTicket save(Bag bag) throws CapacityFullException {
        Optional<Locker> locker = lockers.stream().filter(t -> !t.isFull()).findFirst();
        if (locker.isPresent()) {
            return locker.get().save(bag);
        } else {
            throw new CapacityFullException();
        }
    }

    public Bag pick(LockerTicket ticket) throws NoTicketException {
        Optional<Locker> locker = lockers.stream().filter(t -> t.isIn(ticket)).findFirst();
        if (locker.isPresent()) {
            return locker.get().pick(ticket);
        } else {
            return null;
        }
    }
}
