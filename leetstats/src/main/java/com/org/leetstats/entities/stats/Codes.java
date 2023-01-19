package com.org.leetstats.entities.stats;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="codes", schema = "stats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Codes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code_path")
    private String code_path;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_stats_id")
    private User_stats stats;
}
