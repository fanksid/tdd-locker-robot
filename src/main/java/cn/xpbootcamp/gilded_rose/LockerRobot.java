package cn.xpbootcamp.gilded_rose;

import java.util.Objects;

public class LockerRobot {
    private Bag bag;

    public LockerTicket lock(Bag bag) {
        this.bag = bag;
        return new LockerTicket();
    }

    public Bag pick(LockerTicket ticket) throws NoTicketException {
        if (Objects.isNull(ticket)) {
            throw new NoTicketException();
        }
        return bag;
    }
}
