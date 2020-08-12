package com.generics.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@AllArgsConstructor
@Data
public class Ticket implements Comparable<Ticket>{
    private int id;
    private int price;
    private String from;
    private String to;
    private int timeEnRoute;

    public boolean matches(String from, String to) {
        return this.from.equalsIgnoreCase(from) && this.to.equalsIgnoreCase(to);
    }

    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }
}
