package cn.xpbootcamp.gilded_rose;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LockerRobot {
    private Map<LockerTicket, Bag> locker = new HashMap<>();

    public LockerTicket lock(Bag bag) {
        LockerTicket ticket = new LockerTicket();
        locker.put(ticket, bag);
        return ticket;
    }

    public Bag pick(LockerTicket ticket) throws NoTicketException {
        if (Objects.isNull(ticket)) {
            throw new NoTicketException();
        }
        return locker.remove(ticket);
    }
}
