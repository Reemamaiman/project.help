package com.example.helpstudent.service;

import com.example.helpstudent.dto.RegisterForm;
import com.example.helpstudent.model.Customer;

import com.example.helpstudent.model.User;
import com.example.helpstudent.model.expert;
import com.example.helpstudent.repository.authRepository;

import com.example.helpstudent.repository.customerRepository;
import com.example.helpstudent.repository.expertRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor
public class authService {

private final authRepository authrepository;
private final expertRepository expertrepository;
private final customerRepository customerrepository;


    public void register(RegisterForm registerForm ){
        String hashedPassword=new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedPassword);

        User R =new User(null,registerForm.getUsername(),registerForm.getPassword(),registerForm.getRole(),registerForm.getName(),registerForm.getPhonenumber());
        User newUser = authrepository.save(R);

        if (registerForm.getRole().equals("expert")){
            expert exp=new expert(null,registerForm.getFullname(),registerForm.getJob(),registerForm.getLocation(),newUser.getId());
            expertrepository.save(exp);

        }else {
            Customer customer=new Customer(null,registerForm.getAge(),registerForm.getGender(),newUser.getId());
            customerrepository.save(customer);
        }



    }
}
