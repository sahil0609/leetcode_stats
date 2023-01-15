package com.org.leetstats.entities.stats;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tags", schema = "stats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    public Tag(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

}
