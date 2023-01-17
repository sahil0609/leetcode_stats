package com.org.leetstats.controllers.inject;


import com.org.leetstats.models.auth.CustomUserDetail;
import com.org.leetstats.models.ingest.Question;
import com.org.leetstats.models.ingest.Stats;
import com.org.leetstats.services.ProblemService;
import com.org.leetstats.services.UserStatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//TODO add logging
@RestController
@RequestMapping("/injest")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class InjestController {


    private final ProblemService problemService;

    private final UserStatsService userStatsService;

    @PostMapping("/problem/exists")
    public ResponseEntity<List<String>> checkProblemsExist(@RequestBody List<String> body){
        List<String> result = problemService.checkProblemExist(body);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/problem")
    public ResponseEntity<?> insertProblems(@RequestBody List<Question> body){

        problemService.insertProblems(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);

    }

    @PostMapping("/userstats/")
    public ResponseEntity<?> insertUserStats(@RequestBody List<Stats> stats,
                                             @RequestParam(value="last", defaultValue = "false") boolean isLast,
                                             Authentication authentication){

        CustomUserDetail user = (CustomUserDetail) authentication.getPrincipal();
        userStatsService.insertStats(stats, user, isLast);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);

    }
}
