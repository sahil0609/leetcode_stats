package com.org.leetstats.controllers.auth;

import com.org.leetstats.entities.auth.User;
import com.org.leetstats.enums.RolesEnum;
import com.org.leetstats.models.auth.UserLogin;
import com.org.leetstats.repos.auth.RoleRepo;
import com.org.leetstats.repos.auth.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leetstats/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AuthController {
    private final UserRepo userRepo;

    private final RoleRepo roleRepo;

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;


    @PostMapping("/login")
    public ResponseEntity<?> signin(@RequestBody UserLogin login){
        log.info("started the login process");
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createNewUser(@RequestBody UserLogin signup){
        log.info("signup process started");
        User user = new User();
        user.setName(signup.getName());
        user.setEmail(signup.getEmail());
        user.setPassword(encoder.encode(signup.getPassword()));
        log.info(RolesEnum.USER.name());
        user.setUser_roles(List.of(roleRepo.findByName(RolesEnum.USER.name())
                .get()));

        userRepo.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
