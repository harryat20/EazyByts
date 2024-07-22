//package com.harry.crm;
//
//import com.harry.crm.service.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests -> authorizeRequests
//                        .requestMatchers(
//                                request -> "/login".equals(request.getServletPath()), // Request matcher for /login
//                                request -> request.getServletPath().startsWith("/resources/"), // Request matcher for /resources/**
//                                request -> request.getServletPath().startsWith("/css/"), // Request matcher for /css/**
//                                request -> request.getServletPath().startsWith("/js/"), // Request matcher for /js/**
//                                request -> request.getServletPath().startsWith("/images/") // Request matcher for /images/**
//                        ).permitAll() // Allow access to these URLs without authentication
//                        .anyRequest().authenticated() // All other URLs require authentication
//                )
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/login") // Custom login page URL
//                        .loginProcessingUrl("/signin")
//                        .defaultSuccessUrl("/home", true) // Redirect to /home upon successful login
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .permitAll() // Allow anyone to access the logout URL
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // Use BCryptPasswordEncoder for password hashing
//    }
//}
