package com.tupsi.app.repository;

import java.util.List;

import com.tupsi.app.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByActive(boolean active);
    List<Users> findByCodUser(String codUser);
}
