package com.sahan.workerslobby.Entities;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
public class Ticket implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, unique = true)
    private Long ticketID;

    private String ticketName;

    private String ticketDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_ticket",
            joinColumns = @JoinColumn( name = "ticketID"),
            inverseJoinColumns = @JoinColumn( name = "userID")
    )
    private User userName;
}
