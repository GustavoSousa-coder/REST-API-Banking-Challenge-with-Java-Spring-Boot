package com.challenge.Bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/v1/client").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/client/{uuid}").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.POST, "/api/v1/client").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/client/{uuid}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/v1/account/{ClientUuid}/accounts").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/account/{uuid}/account").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.POST, "/api/v1/account/{clientUuid}").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/account/{uuid}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/v1/addressKey/{accountId}").hasRole("CLIENT")

                        .requestMatchers(HttpMethod.GET, "/api/v1/estatistica").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/v1/transacao/{accountId}").hasRole("CLIENT")
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
