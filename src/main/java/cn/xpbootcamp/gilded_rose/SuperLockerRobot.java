package cn.xpbootcamp.gilded_rose;

import java.util.Comparator;

public class SuperLockerRobot extends LockerRobot {
    public SuperLockerRobot(Locker... lockers) {
        super(lockers);
    }

    @Override
    Comparator<Locker> sort() {
        return (k1, k2) -> 0;
    }
}
