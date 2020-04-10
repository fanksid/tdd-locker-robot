package cn.xpbootcamp.gilded_rose;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static java.util.Comparator.comparingInt;

public class SmartLockerRobot {
    private Locker locker;
    private List<Locker> lockers;

    public SmartLockerRobot(Locker... lockers) {
        this.lockers = Arrays.asList(lockers);
    }

    public LockerTicket save(Bag bag) throws CapacityFullException {
        Optional<Locker> locker = lockers.stream()
                .sorted(comparingInt(Locker::getEmptySpaceSize).reversed())
                .filter(t -> t.hasSpace())
                .findFirst();

        if (locker.isPresent()) {
            return locker.get().save(bag);
        } else {
            throw new CapacityFullException();
        }
    }

    public Bag pick(LockerTicket ticket) throws InvalidTicketException {
        Optional<Locker> locker = lockers.stream().filter(t -> t.isIn(ticket)).findFirst();
        if (locker.isPresent()) {
            return locker.get().pick(ticket);
        } else {
            throw new InvalidTicketException();
        }
    }
}
