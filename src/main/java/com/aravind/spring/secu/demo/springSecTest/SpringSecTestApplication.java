package com.aravind.spring.secu.demo.springSecTest;

import com.aravind.spring.secu.demo.springSecTest.model.ApplicationUser;
import com.aravind.spring.secu.demo.springSecTest.model.Role;
import com.aravind.spring.secu.demo.springSecTest.repository.RoleRepository;
import com.aravind.spring.secu.demo.springSecTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSecTestApplication {
	@Autowired
	AuthenticationManager authenticationManager;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecTestApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncode.encode("password"), roles);

			userRepository.save(admin);
			try {
				System.out.println( authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("admin","passwordd")));
			}
			catch (Exception e){
//				System.out.println(e.getStackTrace());
				e.printStackTrace();
			}

		};
	}
}
