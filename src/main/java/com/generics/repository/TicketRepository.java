package com.generics.repository;


import com.generics.domain.Ticket;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    public void save(Ticket item) {
        Ticket[] tmp = new Ticket[items.length + 1];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;

        items = tmp;

    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("item is not in the repository");
        }

        Ticket[] tmp = new Ticket[items.length - 1];
        int index = 0;

        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Ticket[] findAll() {
        return items;
    }

    public void removeAll() {
        items = new Ticket[0];
    }
}
