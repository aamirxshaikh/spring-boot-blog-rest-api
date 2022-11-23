package com.demo.blogrestapi;

import com.demo.blogrestapi.model.Role;
import com.demo.blogrestapi.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogRestApiApplication implements CommandLineRunner {
    public BlogRestApiApplication(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(BlogRestApiApplication.class, args);
    }

    private final RoleRepository roleRepository;
    @Override
    public void run(String... args) {
        Role admin = new Role();
        Role user = new Role();

        admin.setName("ROLE_ADMIN");
        user.setName("ROLE_USER");

        roleRepository.save(admin);
        roleRepository.save(user);
    }
}
