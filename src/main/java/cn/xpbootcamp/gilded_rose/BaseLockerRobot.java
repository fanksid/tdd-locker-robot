package cn.xpbootcamp.gilded_rose;

import java.util.Arrays;
import java.util.List;

public class BaseLockerRobot {
    protected List<Locker> lockers;

    public BaseLockerRobot(Locker... lockers) {
        this.lockers = Arrays.asList(lockers);
    }

    public LockerTicket save(Bag bag) {
        Locker locker = findAvailableLocker();

        return locker.save(bag);
    }

    protected Locker findAvailableLocker() {
        return lockers.stream()
                .filter(Locker::hasSpace)
                .findFirst()
                .orElseThrow(CapacityFullException::new);
    }

    public Bag pick(LockerTicket ticket) {
        Locker locker = lockers.stream()
                .filter(t -> t.isIn(ticket))
                .findFirst()
                .orElseThrow(InvalidTicketException::new);

        return locker.pick(ticket);
    }
}
