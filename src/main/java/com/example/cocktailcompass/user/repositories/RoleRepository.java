package com.example.cocktailcompass.user.repositories;

import com.example.cocktailcompass.user.models.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository {
    Optional<Role> findByRoleName(String roleName);
}
