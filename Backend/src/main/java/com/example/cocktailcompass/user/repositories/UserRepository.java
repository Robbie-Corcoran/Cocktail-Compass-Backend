package com.example.cocktailcompass.user.repositories;

import com.example.cocktailcompass.user.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsernameOrEmail (String username, String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
