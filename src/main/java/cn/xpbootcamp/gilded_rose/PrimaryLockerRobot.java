package cn.xpbootcamp.gilded_rose;

import java.util.Comparator;

public class PrimaryLockerRobot extends LockerRobot {

    public PrimaryLockerRobot(Locker... lockers) {
        super(lockers);
    }

    public Comparator<Locker> sort() {
        return (o1, o2) -> 0;
    }

}
