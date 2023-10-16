package com.aravind.spring.secu.demo.springSecTest.service;

import com.aravind.spring.secu.demo.springSecTest.model.ApplicationUser;
import com.aravind.spring.secu.demo.springSecTest.model.Role;
import com.aravind.spring.secu.demo.springSecTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //  System.out.printf(username);
//        Set<Role> roles= new HashSet<>();
//        roles.add(new Role(1,"USER"));
//        System.out.printf(passwordEncoder.encode("raja"));
//        new UsernamePasswordAuthenticationToken("ss","ss");
//        return  new ApplicationUser(1,"arav",passwordEncoder.encode( "raja"),roles);
        System.out.println(username);
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }
}
