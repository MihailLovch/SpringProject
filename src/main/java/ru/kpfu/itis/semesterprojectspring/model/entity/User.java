package ru.kpfu.itis.semesterprojectspring.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Integer height;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Boolean sex;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(
            name =  "user_recipe",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "recipe_id")}
    )
    private List<Recipe> preferredRecipes = new ArrayList<>();


}
