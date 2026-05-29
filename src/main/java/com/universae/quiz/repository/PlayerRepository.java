package com.universae.quiz.repository;

import com.universae.quiz.model.Player;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.universae.quiz.repository.springdata.PlayerSpringDataRepository;

@Repository
public class PlayerRepository {

        private final PlayerSpringDataRepository playerSpringDataRepository;

        public PlayerRepository(PlayerSpringDataRepository playerSpringDataRepository) {
            this.playerSpringDataRepository = playerSpringDataRepository;
        }

        public Player save(Player player) {
            return playerSpringDataRepository.save(player);
        }

        public Optional<Player> findById(Long id) {
            return playerSpringDataRepository.findById(id);
        }

        public void deleteById(Long id) {
            playerSpringDataRepository.deleteById(id);
        }

        public Optional<Player> findByEmail(String email){
            return playerSpringDataRepository.findByEmail(email);
        }
}
