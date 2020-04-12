package cn.xpbootcamp.gilded_rose;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Locker {
    private Map<LockerTicket, Bag> locker = new HashMap<>();
    private int capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public LockerTicket save(Bag bag) {
        if (locker.size() >= capacity) {
            throw new CapacityFullException();
        }
        LockerTicket ticket = new LockerTicket();
        locker.put(ticket, bag);
        return ticket;
    }

    public Bag pick(LockerTicket ticket) {
        if (Objects.isNull(ticket)) {
            throw new InvalidTicketException();
        }
        return locker.remove(ticket);
    }

    public boolean hasSpace() {
        return capacity != locker.size();
    }

    public boolean isIn(LockerTicket ticket) {
        return locker.containsKey(ticket);
    }

    public int getAvailableSpaceSize() {
        return capacity - locker.size();
    }
}
