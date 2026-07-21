package com.universae.quiz.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String alias;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private Integer score = 0;

    @OneToMany(mappedBy = "player")
    private List<GameQuestion> gameQuestions;

    @OneToMany(mappedBy = "player")
    private List<PlayerGame> playerGames;

}

