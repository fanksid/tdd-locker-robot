package cn.xpbootcamp.gilded_rose;

public class SmartLockerRobot {
    private Locker locker;

    public SmartLockerRobot(Locker locker) {
        this.locker = locker;
    }

    public SmartLockerRobot(Locker... lockers) {
        this.locker = lockers[0];
    }

    public LockerTicket save(Bag bag) throws CapacityFullException {
        return locker.save(bag);
    }

    public Bag pick(LockerTicket ticket) throws InvalidTicketException {
        return locker.pick(ticket);
    }
}
