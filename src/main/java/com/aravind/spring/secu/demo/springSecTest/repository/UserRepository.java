package com.aravind.spring.secu.demo.springSecTest.repository;

import java.util.Optional;

import com.aravind.spring.secu.demo.springSecTest.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer> {
    Optional<ApplicationUser> findByUsername(String username);
}