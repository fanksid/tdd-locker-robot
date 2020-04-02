package cn.xpbootcamp.gilded_rose;

public class PrimaryLockerRobot {
    private Locker locker;

    public PrimaryLockerRobot(Locker locker) {
        this.locker = locker;
    }

    public LockerTicket save(Bag bag) throws CapacityFullException {
        return locker.save(bag);
    }

    public Bag pick(LockerTicket ticket) throws NoTicketException {
        return locker.pick(ticket);
    }
}
