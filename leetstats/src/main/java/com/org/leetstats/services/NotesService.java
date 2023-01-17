package com.org.leetstats.services;

import com.org.leetstats.entities.auth.User;
import com.org.leetstats.entities.stats.Notes;
import com.org.leetstats.entities.stats.Problem;
import com.org.leetstats.enums.InjestExceptionEnum;
import com.org.leetstats.exceptions.InjestException;
import com.org.leetstats.repos.injest.NotesRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class NotesService {

    private final FileService fileService;

    private final NotesRepo notesRepo;

    public void InsertNotes(User userDAO, Problem problem, String note){
        Notes notes = new Notes();
        notes.setUser(userDAO);
        notes.setProblem(problem);
        try {
            String target = fileService.createNotes(note);
            notes.setNote_location(target);
        }
        catch (IOException ex){
            log.error("Some error occurred while creating the code file", ex);
            throw new InjestException(InjestExceptionEnum.INTERNAL_SERVER_ERROR,"Some error occurred");
        }
        notesRepo.save(notes);
    }
}
