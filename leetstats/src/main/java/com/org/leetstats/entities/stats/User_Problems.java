package com.org.leetstats.entities.stats;

import com.org.leetstats.entities.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_problems", schema = "stats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User_Problems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int success;
    @Column
    private int failure;
    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
