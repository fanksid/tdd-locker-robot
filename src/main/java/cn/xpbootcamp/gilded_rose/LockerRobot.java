package cn.xpbootcamp.gilded_rose;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class LockerRobot {
    protected List<Locker> lockers;

    public LockerRobot(Locker... lockers) {
        this.lockers = Arrays.asList(lockers);
    }

    abstract Comparator<Locker> sort();

    public LockerTicket save(Bag bag) {
        Locker locker = lockers.stream()
                .sorted(sort())
                .filter(Locker::hasSpace)
                .findFirst()
                .orElseThrow(CapacityFullException::new);

        return locker.save(bag);
    }

    public Bag pick(LockerTicket ticket) {
        Locker locker = lockers.stream()
                .filter(t -> t.isIn(ticket))
                .findFirst()
                .orElseThrow(InvalidTicketException::new);

        return locker.pick(ticket);
    }
}
