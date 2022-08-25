package com.example.helpstudent.service;

import com.example.helpstudent.model.Customer;
import com.example.helpstudent.model.expert;
import com.example.helpstudent.repository.expertRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor

public class expertService {
    private final expertRepository  expertrepository;


    public List<expert> get_expert(){
        return expertrepository.findAll();
    }
    public void add_expert(expert ex){
        expertrepository.save(ex);
    }
public void update_expert(expert ex, Integer id){
    expert exp=expertrepository.getById(id);
    ex.setFullname(ex.getFullname());
    ex.setJob(ex.getJob());

    expertrepository.save(ex);
}

public void delete_expert(Integer id){
        expert myExpert= expertrepository.getById(id);
        expertrepository.delete(myExpert);
}



}
