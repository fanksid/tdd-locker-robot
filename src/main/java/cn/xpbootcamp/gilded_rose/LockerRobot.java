package cn.xpbootcamp.gilded_rose;

import java.util.Comparator;

public abstract class LockerRobot extends BaseLockerRobot {
    public LockerRobot(Locker... lockers) {
        super(lockers);
    }

    abstract Comparator<Locker> sort();

    @Override
    protected Locker findAvailableLocker() {
        return lockers.stream()
                .sorted(sort())
                .filter(Locker::hasSpace)
                .findFirst()
                .orElseThrow(CapacityFullException::new);
    }
}
