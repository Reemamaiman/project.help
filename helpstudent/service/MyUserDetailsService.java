package com.example.helpstudent.service;

import com.example.helpstudent.model.User;
import com.example.helpstudent.repository.authRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    public final authRepository authrepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authrepository.findUserByUsername(username);

        if (user==null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return user;
    }

}

