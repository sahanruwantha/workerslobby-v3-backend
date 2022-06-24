package com.sahan.workerslobby.Services.Impl;

import com.sahan.workerslobby.Entities.TaskAndTicket;
import com.sahan.workerslobby.Entities.Ticket;
import com.sahan.workerslobby.Entities.User;
import com.sahan.workerslobby.Exceptions.UserNotFoundException;
import com.sahan.workerslobby.Repositories.TicketRepository;
import com.sahan.workerslobby.Services.TicketService;

import java.io.IOException;

public class TicketServiceImpl implements TicketService
{
    private TicketRepository ticketRepository;
    private UserService userService;


    @Override
    public Ticket createTicket(long id, String ticketName, String ticketDescription) throws UserNotFoundException {
        User client = userService.validateUserById(id);
        Ticket ticket = new Ticket(id,ticketName,ticketDescription, client);
        TaskAndTicket taskAndTicket
        ticketRepository.save(ticket);
        return null;
    }

    @Override
    public Ticket updateTicket(String ticketName, String ticketDescription) throws IOException {
        Ticket updateTicket = validateTicket(ticketName);
        updateTicket.setTicketName(ticketName);
        updateTicket.setTicketDescription(ticketDescription);
        ticketRepository.save(updateTicket);
        return updateTicket;
    }

    private Ticket validateTicket(String ticketName) throws IOException {
        Ticket ticket = ticketRepository.findTicketByTicketName(ticketName);
        if (ticket == null)
        {
            throw new IOException("Error occurred");
        }
        return ticket;
    }
}
