package com.org.leetstats.repos.injest;

import com.org.leetstats.entities.stats.Problem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepo extends CrudRepository<Problem, Integer> {
}
