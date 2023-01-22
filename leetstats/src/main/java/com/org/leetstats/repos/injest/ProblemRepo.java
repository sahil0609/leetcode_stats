package com.org.leetstats.repos.injest;

import com.org.leetstats.entities.stats.Problem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProblemRepo extends CrudRepository<Problem, Integer> {
    List<Problem> findByLeetcodenameInIgnoreCase(Collection<String> leetcode_name);
    long deleteByName(String name);
    Optional<Problem> findByNameIgnoreCase(String name);
    List<Problem> findByNameInIgnoreCase(Collection<String> names);
}
