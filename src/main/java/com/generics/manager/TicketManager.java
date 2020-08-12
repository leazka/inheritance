package com.generics.manager;

import com.generics.domain.Ticket;
import com.generics.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public void add(Ticket item) {
        repository.save(item);
    }


    public Ticket[] findAll() {
        Ticket[] tickets = repository.findAll();
        return tickets;

    }

    public Ticket findById(int id) {
        Ticket ticket = repository.findById(id);
        return ticket;
    }

    public void removeAll() {
        repository.removeAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] tickets = repository.findAll();
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : tickets) {
            if (ticket.matches(from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
