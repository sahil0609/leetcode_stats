package com.org.leetstats.repos.injest;

import com.org.leetstats.entities.stats.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends CrudRepository<Tag, Integer> {
}
