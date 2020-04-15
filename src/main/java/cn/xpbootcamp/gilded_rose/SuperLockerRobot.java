package cn.xpbootcamp.gilded_rose;

import java.util.Comparator;
import static java.util.Comparator.comparingDouble;

public class SuperLockerRobot extends LockerRobot {
    public SuperLockerRobot(Locker... lockers) {
        super(lockers);
    }

    @Override
    Comparator<Locker> sort() {
        return comparingDouble(Locker::getEmptySpaceRate).reversed();
    }
}
