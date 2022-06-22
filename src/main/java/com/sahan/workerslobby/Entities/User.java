package com.sahan.workerslobby.Entities;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(nullable = false, updatable = false, unique = true)
    private String userID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private String role;
    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked;


//    @OneToMany(mappedBy = "taskID")
//    private List<Task> relatedTasks;
//
//    @OneToMany(mappedBy = "ticketID")
//    private List<Ticket> relatedTickets;
//
//    @ManyToOne
//    @JoinTable(
//            name = "company_user",
//            joinColumns = @JoinColumn( name = "userID"),
//            inverseJoinColumns = @JoinColumn( name = "companyID")
//    )
//    private Company company;
}
