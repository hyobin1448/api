//package com.api.report.api.service;
//
//
//import com.api.report.api.repository.UserRepository;
//import com.api.report.api.model.UserDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public int insertUser(UserDto dto) {
//        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
//        return userRepository.insertUser(dto);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDto user = userRepository.searchUser(username);
//        return user;
//    }
//}
