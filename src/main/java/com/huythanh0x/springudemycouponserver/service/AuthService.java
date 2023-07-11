package com.huythanh0x.springudemycouponserver.service;

import com.huythanh0x.springudemycouponserver.exception.BadRequestException;
import com.huythanh0x.springudemycouponserver.model.user.Role;
import com.huythanh0x.springudemycouponserver.model.user.UserEntity;
import com.huythanh0x.springudemycouponserver.repository.RoleRepository;
import com.huythanh0x.springudemycouponserver.repository.UserRepository;
import com.huythanh0x.springudemycouponserver.security.JWTGenerator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AuthService {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    public AuthService(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    public void checkIfUserExist(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new BadRequestException("Username is taken!");
        }
    }

    public void validateRegisterData(String username, String password) {
        if (username == null || password == null) {
            throw new BadRequestException("Invalid username or password, try again !!!");
        }
        if (username.length() < 6 || password.length() < 6) {
            throw new BadRequestException("Username and password can not have length less than 6");
        }
    }

    public void validateLoginData(String username, String password) {
        if (username == null || password == null) {
            throw new BadRequestException("Invalid username or password, try again !!!");
        }
        if (username.isEmpty() || password.isEmpty()) {
            throw new BadRequestException("Username and password can not have length less than 6");
        }
    }

    public String getJwtTokenForCurrentUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtGenerator.generateToken(authentication);
    }

    public void createUserWith(String username, String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        Optional<Role> roles = roleRepository.findByName("USER");
        roles.ifPresent(role -> user.setRoles(Collections.singletonList(role)));
        userRepository.save(user);
    }
}
