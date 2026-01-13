package com.example.bdbt_projekt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/index").permitAll()
                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                        .requestMatchers("/admin_main").hasRole("ADMIN")
                        .requestMatchers("/prezenter_main").hasRole("PREZENTER")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/perspectives", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/index")
                        .permitAll()
                );
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails prezenter1 = User.withUsername("prezenter1")
                .password(passwordEncoder().encode("prezenter1"))
                .roles("PREZENTER")
                .build();
        UserDetails prezenter2 = User.withUsername("prezenter2")
                .password(passwordEncoder().encode("prezenter2"))
                .roles("PREZENTER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(prezenter1, prezenter2, admin);
    }
}
