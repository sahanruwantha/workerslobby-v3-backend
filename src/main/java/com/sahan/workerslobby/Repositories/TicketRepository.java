package com.sahan.workerslobby.Repositories;

import com.sahan.workerslobby.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long>
{
    Ticket findTicketByTicketName(String ticket);
}
