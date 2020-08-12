package com.generics.repository;

import com.generics.domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketRepositoryTest {

    TicketRepository repository = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 100, "LED", "AMS", 180);
    Ticket ticket2 = new Ticket(2, 260, "AMS", "CPT", 480);
    Ticket ticket3 = new Ticket(3, 120, "LED", "AMS", 160);
    Ticket ticket4 = new Ticket(4, 280, "AMS", "CPT", 510);

    @BeforeEach
    void setUp() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
    }

    @Test
    void shouldThrowExceptionIfNotExist() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }

    @Test
    void shouldRemove(){
        Ticket[] expected = {ticket1, ticket2, ticket3};
        repository.removeById(4);
        assertArrayEquals(expected, repository.findAll());
    }

}