package com.org.leetstats.repos.injest;

import com.org.leetstats.entities.stats.Codes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepo extends CrudRepository<Codes, Integer> {
}
