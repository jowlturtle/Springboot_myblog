package com.cos.myblog.Config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       // http.csrf(csrf -> csrf.disable());

        http
                .authorizeHttpRequests
                        (authorizeRequests -> authorizeRequests
                                .requestMatchers("/auth/**").permitAll()
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                                .anyRequest().authenticated());

        http.formLogin(login -> login.loginPage("/auth/loginForm"));
        return http.build();
    }
}
