package com.org.leetstats.repos.injest;

import com.org.leetstats.entities.stats.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepo extends CrudRepository<Tag, Integer> {
    Optional<Tag> findByName(String name);
}
