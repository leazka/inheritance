package com.generics.manager;

import com.generics.domain.Ticket;
import com.generics.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class TicketManagerTest {

    @Mock
    TicketRepository repository;
    @InjectMocks
    TicketManager manager;
    Ticket ticket1 = new Ticket(1, 100, "LED", "AMS", 180);
    Ticket ticket2 = new Ticket(2, 260, "AMS", "CPT", 480);
    Ticket ticket3 = new Ticket(3, 120, "LED", "AMS", 160);
    Ticket ticket4 = new Ticket(4, 280, "AMS", "CPT", 510);

    @BeforeEach
    void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
    }

    @Test
    public void shouldFindById() {
        Ticket returned = ticket2;
        doReturn(returned).when(repository).findById(2);

        assertEquals(ticket2, manager.findById(2));
    }

    @Test
    public void shouldRemoveAll() {
        Ticket[] emptyArray = new Ticket[0];
        doReturn(emptyArray).when(repository).findAll();

        manager.removeAll();
        assertArrayEquals(emptyArray, manager.findAll());

    }


    @Test
    public void shouldRemoveById() {
        Ticket[] expected = {ticket1, ticket2, ticket3};
        doReturn(expected).when(repository).findAll();

        manager.removeById(4);
        assertArrayEquals(expected, manager.findAll());

    }

    @Test
    public void shouldSearchBy() {
        Ticket[] products = {ticket1, ticket2, ticket3, ticket4};
        doReturn(products).when(repository).findAll();

        Ticket[] expectedTickets = {ticket1,  ticket3};
        Ticket[] returnedTickets = manager.searchBy("LED", "AMS");
        assertArrayEquals(expectedTickets, returnedTickets);


        Ticket[] emptyArray = new Ticket[0];
        Ticket[] returnedTickets2 = manager.searchBy("AMS", "LED");
        assertArrayEquals(emptyArray, returnedTickets2);

    }


}