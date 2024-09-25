package co.vinni.Autenticacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Deshabilitar CSRF si no usas formularios web (opcional)
                .authorizeHttpRequests((requests) -> requests
                        // Permitir acceso sin autenticación a todas las rutas
                        .anyRequest().permitAll()
                );

        // Configuración para la consola H2 (solo en desarrollo)
        http.headers().frameOptions().disable();

        return http.build();
    }
}
