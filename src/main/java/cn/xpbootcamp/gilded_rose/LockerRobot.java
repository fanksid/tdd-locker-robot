package cn.xpbootcamp.gilded_rose;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public abstract class LockerRobot {
    protected List<Locker> lockers;

    public LockerRobot(Locker... lockers) {
        this.lockers = Arrays.asList(lockers);
    }

    abstract Comparator<Locker> sort();

    public LockerTicket save(Bag bag) {
        Optional<Locker> locker = lockers.stream()
                .sorted(sort())
                .filter(Locker::hasSpace)
                .findFirst();

        if (locker.isPresent()) {
            return locker.get().save(bag);
        } else {
            throw new CapacityFullException();
        }
    }

    public Bag pick(LockerTicket ticket) {
        Optional<Locker> locker = lockers.stream()
                .filter(t -> t.isIn(ticket))
                .findFirst();

        if (locker.isPresent()) {
            return locker.get().pick(ticket);
        } else {
            throw new InvalidTicketException();
        }
    }
}
