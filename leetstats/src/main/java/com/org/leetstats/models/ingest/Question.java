package com.org.leetstats.models.ingest;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    private String questionId;
    private String title;
    private String difficulty;
    private boolean isPaidOnly;
    private List<String> tags;

    private String leetcode_name;
}
