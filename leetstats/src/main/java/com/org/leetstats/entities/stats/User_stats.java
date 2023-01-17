package com.org.leetstats.entities.stats;

import com.org.leetstats.entities.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_stats", schema = "stats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User_stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String memory;
    @Column(name = "lang")
    private String language;
    @Column
    private String status;
    @Column
    private int runtime;

    @Column
    private long time;
    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "stats")
    private Codes code;








}
