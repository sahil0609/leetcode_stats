package com.org.leetstats.entities.stats;

import com.org.leetstats.enums.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="problems", schema = "stats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int leetcode_id;
    @Column
    private String name;

    private Level level;

    @Column
    private boolean is_premium;

    @ManyToMany
    @JoinTable(name = "problem_tags",
            schema="stats",
            joinColumns = {@JoinColumn(name="problem_id")},
            inverseJoinColumns = {@JoinColumn(name="tag_id")}
    )
    private List<Tag> tags;


}
