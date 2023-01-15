package com.org.leetstats.repos.injest;

import com.org.leetstats.entities.stats.User_Problems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_ProblemsRepo extends CrudRepository<User_Problems, Integer> {
}
