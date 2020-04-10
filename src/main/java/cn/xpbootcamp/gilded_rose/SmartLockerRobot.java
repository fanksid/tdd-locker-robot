package cn.xpbootcamp.gilded_rose;

import java.util.Comparator;
import static java.util.Comparator.comparingInt;

public class SmartLockerRobot extends LockerRobot {

    public SmartLockerRobot(Locker... lockers) {
        super(lockers);
    }

    public Comparator<Locker> sort() {
        return comparingInt(Locker::getEmptySpaceSize).reversed();
    }
}
