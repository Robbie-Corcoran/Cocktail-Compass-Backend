package com.example.cocktailcompass;

import com.example.cocktailcompass.user.models.RoleEntity;
import com.example.cocktailcompass.user.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CocktailCompassApplication {

    public static void main(String[] args) {
        SpringApplication.run(CocktailCompassApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(RoleRepository roleRepository){
        return (args -> {
            RoleEntity admin = new RoleEntity();
            admin.setName("ROLE_ADMIN");
            roleRepository.save(admin);

            RoleEntity user = new RoleEntity();
            admin.setName("ROLE_USER");
            roleRepository.save(user);
        });
    }
}
