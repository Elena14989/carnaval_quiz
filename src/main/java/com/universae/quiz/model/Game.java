package com.universae.quiz.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String status;

    @OneToMany(mappedBy = "game")
    private List<GameQuestion> gameQuestions;

    @OneToMany(mappedBy = "game")
    private List<PlayerGame> playerGames;

}

