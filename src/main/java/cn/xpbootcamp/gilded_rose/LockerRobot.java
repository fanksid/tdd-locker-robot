package cn.xpbootcamp.gilded_rose;

public class LockerRobot {
    private Bag bag;

    public LockerTicket lock(Bag bag) {
        this.bag = bag;
        return new LockerTicket();
    }

    public Bag pick(LockerTicket ticket) {
        return bag;
    }
}
