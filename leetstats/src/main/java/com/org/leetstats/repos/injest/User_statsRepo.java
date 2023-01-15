package com.org.leetstats.repos.injest;

import com.org.leetstats.entities.stats.User_stats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_statsRepo extends CrudRepository<User_stats, Integer> {
}
