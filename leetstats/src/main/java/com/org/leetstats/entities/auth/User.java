package com.org.leetstats.entities.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.leetstats.enums.LoginType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="user",schema = "userdata")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="email")
    private String email;
    @Column(name="password")
    @JsonIgnore
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="is_locked")
    private boolean is_locked;
    @Enumerated(EnumType.STRING)
    private LoginType loginType;
   @ManyToMany
   @JoinTable(
           name="user_roles",
           schema = "userdata",
           joinColumns = { @JoinColumn(name = "user_id") },
           inverseJoinColumns = { @JoinColumn(name = "role_id") }

   )
    private List<Role> user_roles;
}
