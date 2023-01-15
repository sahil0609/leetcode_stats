package com.org.leetstats.repos.injest;

import com.org.leetstats.entities.stats.Notes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepo extends CrudRepository<Notes, Integer> {
}
