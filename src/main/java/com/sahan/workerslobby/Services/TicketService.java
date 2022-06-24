package com.sahan.workerslobby.Services;

import com.sahan.workerslobby.Entities.Ticket;
import com.sahan.workerslobby.Exceptions.UserNotFoundException;

import java.io.IOException;

public interface TicketService
{
    Ticket createTicket(long id, String ticketName, String ticketDescription) throws UserNotFoundException;
    Ticket updateTicket(String ticketName, String ticketDescription) throws IOException;
}
