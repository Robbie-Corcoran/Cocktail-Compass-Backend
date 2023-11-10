package com.example.cocktailcompass.user.controllers;

import com.example.cocktailcompass.user.models.RoleEntity;
import com.example.cocktailcompass.user.models.UserEntity;
import com.example.cocktailcompass.user.models.dtos.UserLoginDTO;
import com.example.cocktailcompass.user.models.dtos.UserSignUpDTO;
import com.example.cocktailcompass.user.repositories.RoleRepository;
import com.example.cocktailcompass.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserLoginDTO userLoginDTO){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userLoginDTO.getUsername(), userLoginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("User login successful.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserSignUpDTO userSignUpDTO) {
        if(userRepository.existsByUsername(userSignUpDTO.getUsername())) {
            return new ResponseEntity<>("Username is already in use.", HttpStatus.CONFLICT);
        }

        if(userRepository.existsByEmail(userSignUpDTO.getEmail())){
            return new ResponseEntity<>("Email is already in use.", HttpStatus.CONFLICT);
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userSignUpDTO.getName());
        userEntity.setUserName(userSignUpDTO.getUsername());
        userEntity.setEmail(userSignUpDTO.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userSignUpDTO.getPassword()));

        RoleEntity roles = roleRepository.findByName("ROLE_ADMIN").get();
        userEntity.setRoles(Collections.singleton(roles));

        userRepository.save(userEntity);

        return new ResponseEntity<>("User registration successful", HttpStatus.OK);
    }
}
