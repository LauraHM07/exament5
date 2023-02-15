package com.oretania.portal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.oretania.portal.services.AlumnoService;

@Configuration
public class SecurityConfig {

    @Bean
    AlumnoService myStudentService() {
        return new AlumnoService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(myStudentService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .anyRequest()
            .authenticated()
        .and()
            .formLogin()
        .and()
            .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService user() {
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}kaka")
                .authorities("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}1234")
                .authorities("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}