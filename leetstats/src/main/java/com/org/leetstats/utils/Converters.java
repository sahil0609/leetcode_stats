package com.org.leetstats.utils;

import com.org.leetstats.entities.stats.Problem;
import com.org.leetstats.entities.stats.Tag;
import com.org.leetstats.entities.stats.User_stats;
import com.org.leetstats.enums.Level;
import com.org.leetstats.models.ingest.Question;
import com.org.leetstats.models.ingest.Stats;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;

import java.util.List;

@Slf4j
public class Converters {

    public static Problem ConvertQuestionsToProblems(Question question){
        if(question == null) return null;
        Problem p = new Problem();
        p.set_premium(question.isPaidOnly());
        p.setName(question.getTitle());
        p.setLevel(Level.valueOf(question.getDifficulty().toUpperCase()));
        p.setLeetcode_id(Integer.parseInt(question.getQuestionId()));
        List<Tag> tags = question.getTags().stream().map(Tag::new).toList();
        p.setTags(tags);
        return p;
    }

    public static Pair<User_stats, Stats> ConvertStatsToUserstats(Stats stat){
        User_stats user_stats = new User_stats();
        user_stats.setStatus(stat.getStatus());
        user_stats.setLanguage(stat.getLanguage());
        user_stats.setMemory(stat.getMemory());
        user_stats.setTime(stat.getTimestamp());
        String runtime = stat.getRuntime();
        if(runtime.equalsIgnoreCase("N/A")){
            user_stats.setRuntime(-1);
        }
        else{
            try {
                user_stats.setRuntime(Integer.parseInt(runtime.split(" ")[0]));
            }
            catch (Exception e){
                log.error("could not convert runtime Error:"+e);
                user_stats.setRuntime(-1);
            }
        }

        return Pair.of(user_stats, stat);

    }
}
