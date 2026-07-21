package com.universae.quiz.security;

// Importamos nuestra entidad Player
import com.universae.quiz.model.Player;

// Importamos el servicio de jugadores (ya no usamos el repositorio directamente)
import com.universae.quiz.service.PlayerService;

// Indica que esta clase es un servicio de Spring
import org.springframework.stereotype.Service;

// Clases de Spring Security
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PlayerService playerService;


    public CustomUserDetailsService(PlayerService playerService) {
        this.playerService = playerService;
    }

    // Spring Security llamará automáticamente a este metodo cuando alguien intente iniciar sesion
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        // Buscamos el jugador usando el servicio
        Player player = playerService.findByEmail(email);

        // Traducimos nuestro Player al formato que Spring Security entiende
        return new User(

                // Usuario (en nuestro caso será el email)
                player.getEmail(),

                // Contraseña (ahora mismo será texto plano, después será un hash BCrypt)
                player.getPassword(),

                // Rol del usuario
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}