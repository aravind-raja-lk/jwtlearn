package com.aravind.spring.secu.demo.springSecTest.repository;

import java.util.Optional;

import com.aravind.spring.secu.demo.springSecTest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByAuthority(String authority);
}