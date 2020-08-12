package com.generics.comparator;

import com.generics.domain.Ticket;

import java.util.Comparator;

public class TicketsByTimeEnRoute implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTimeEnRoute() - o2.getTimeEnRoute();
    }
}
