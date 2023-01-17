package com.org.leetstats.models.ingest;

import lombok.Data;

@Data
public class Stats {

    private String code;
    private String notes;
    private String status;
    private String memory;
    private String language;
    private Long timestamp;
    private String runtime;
    private String questionTitle;
    private boolean isNotesPresent;

}
