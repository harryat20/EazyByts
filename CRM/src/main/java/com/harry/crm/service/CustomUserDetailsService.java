//package com.harry.crm.service;
//
//import com.harry.crm.dao.UserRepository;
//import com.harry.crm.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collections;
//
//@Service
//public class CustomUserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public User login(String username, String password) {
//        return userRepository.findUserByUsernameAndPassword(username, password);
//    }
//
//
//}
