package com.org.leetstats.services;

import com.org.leetstats.entities.auth.User;
import com.org.leetstats.entities.stats.Codes;
import com.org.leetstats.entities.stats.Problem;
import com.org.leetstats.entities.stats.User_stats;
import com.org.leetstats.enums.InjestExceptionEnum;
import com.org.leetstats.exceptions.InjestException;
import com.org.leetstats.models.auth.CustomUserDetail;
import com.org.leetstats.models.ingest.Stats;
import com.org.leetstats.repos.auth.UserRepo;
import com.org.leetstats.repos.injest.ProblemRepo;
import com.org.leetstats.repos.injest.User_statsRepo;
import com.org.leetstats.utils.Converters;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserStatsService {
    private final User_statsRepo userStatsRepo;
    private final ProblemRepo problemRepo;
    private final UserRepo userRepo;
    private final CodeService codeService;

    private final NotesService notesService;

    private void insertStats(List<Stats> stats, CustomUserDetail user){
        User userDAO = userRepo.findByEmail(user.getUsername()).orElseThrow(() ->new InjestException("Some Error occured"));
        List<Pair<User_stats, Stats>>  statsQuestionPair = stats.stream().map(Converters::ConvertStatsToUserstats).toList();

        List<User_stats> user_stats = statsQuestionPair.stream().map((pair) -> {
            User_stats s = pair.getFirst();
            Stats st = pair.getSecond();
            Problem problem = problemRepo.findByNameIgnoreCase(st.getQuestionTitle())
                    .orElseThrow(() -> new InjestException(InjestExceptionEnum.BAD_REQUEST,"Problem not found"));
            Codes code = codeService.getCodes(s, st.getCode());

            if(st.isNotesPresent()) notesService.InsertNotes(userDAO, problem, st.getNotes());

            s.setCode(code);
            s.setProblem(problem);
            s.setUser(userDAO);
            return s;
        }).toList();
        userStatsRepo.saveAll(user_stats);
    }

    public void insertStats(List<Stats> stats, CustomUserDetail user, boolean isLast) {
        this.insertStats(stats, user);

        if(isLast){
            //TODO add a future to add into the user_Data here
        }
    }
}