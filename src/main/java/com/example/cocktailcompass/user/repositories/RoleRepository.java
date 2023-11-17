package com.example.cocktailcompass.user.repositories;

import com.example.cocktailcompass.user.models.ERole;
import com.example.cocktailcompass.user.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(ERole roleName);
}
