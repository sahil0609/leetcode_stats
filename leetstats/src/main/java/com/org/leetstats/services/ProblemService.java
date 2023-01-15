package com.org.leetstats.services;

import com.org.leetstats.entities.stats.Problem;
import com.org.leetstats.enums.InjestExceptionEnum;
import com.org.leetstats.enums.Level;
import com.org.leetstats.exceptions.InjestException;
import com.org.leetstats.models.ingest.Question;
import com.org.leetstats.repos.injest.ProblemRepo;
import com.org.leetstats.utils.Converters;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProblemService {

    private final ProblemRepo problemRepo;


    public List<String> checkProblemExist(List<String> problems){
        List<String> result = problemRepo.findByNameInIgnoreCase(problems).stream().map(Problem::getName).toList();

        return problems.stream()
                .filter((val) -> !result.contains(val)).toList();
    }

    public void insertProblems(List<Question> questions){

        List<Problem> problems = questions.stream().map(Converters::ConvertQuestionsToProblems).toList();
        problemRepo.saveAll(problems);
    }

    public void updateProblem(Question question){
        Problem problem = problemRepo.findByNameIgnoreCase(question.getTitle()).orElseThrow(() -> new InjestException(InjestExceptionEnum.BAD_REQUEST, "Problem not found"));
        Problem updated = Converters.ConvertQuestionsToProblems(question);
        updated.setId(problem.getId());
        problemRepo.save(updated);
    }

    public void deleteProblem(String name){
        problemRepo.deleteByName(name);
    }

}
