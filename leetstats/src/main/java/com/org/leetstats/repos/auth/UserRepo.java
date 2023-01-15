package com.org.leetstats.repos.auth;

import com.org.leetstats.entities.auth.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    long deleteByEmail(String email);

    Optional<User> findByEmail(String email);


}
