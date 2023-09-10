package com.ali.springsecurityexample.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
                joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id")},
                inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "role_id")})
    private List<Role> roles;
}