package com.org.leetstats.services;

import com.org.leetstats.entities.auth.User;
import com.org.leetstats.models.auth.CustomUserDetail;
import com.org.leetstats.repos.auth.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomUserDetailsManager implements UserDetailsManager {

    private final UserRepo userRepo;


    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {
        userRepo.deleteByEmail(username);

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return userRepo.findByEmail(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDAO = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("username not found"));
        return new CustomUserDetail(userDAO.getEmail(), userDAO.getPassword(), userDAO.is_locked(), userDAO.getUser_roles());

    }
}
