package com.cos.myblog.Config;

import com.cos.myblog.Config.auth.PrincipalDetail;
import com.cos.myblog.Config.auth.PrincipalDetailService;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PrincipalDetailService principalDetailService;

    @Bean
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()); //csrf 토큰 비활성화

        http
                .authorizeHttpRequests
                        (authorizeRequests -> authorizeRequests
                                .requestMatchers("/auth/**","/js/**","css/**", "/image/**","/", "/dummy/**").permitAll()
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                                .anyRequest().authenticated());

        http.formLogin(login -> login
                                        .loginPage("/auth/loginForm")
                                        .loginProcessingUrl("/auth/loginProc")
                                        .defaultSuccessUrl("/")
                                        );

        return http.build();
    }
}
