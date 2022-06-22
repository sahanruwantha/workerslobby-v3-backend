package com.sahan.workerslobby.Repositories;

import com.sahan.workerslobby.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>
{
    User findUserByUserName(String username);
    User findUserByEmail(String email);
}

