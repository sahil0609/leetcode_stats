package com.org.leetstats.entities.auth;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="roles", schema = "userdata")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

}
