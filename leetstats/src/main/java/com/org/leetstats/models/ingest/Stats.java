package com.org.leetstats.models.ingest;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    //"is" is removed by the lomobok setter method so the value of the field in the json is NotesPresent
    @JsonProperty
    private boolean isNotesPresent;

}
