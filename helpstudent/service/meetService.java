package com.example.helpstudent.service;

import com.example.helpstudent.model.expert;
import com.example.helpstudent.model.meet;
import com.example.helpstudent.repository.expertRepository;
import com.example.helpstudent.repository.meetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class meetService {
    private final meetRepository meetrepository;


    public List<meet> get_meet() {
        return meetrepository.findAll();
    }

    public void add_meet( meet me) {
        meetrepository.save(me);
    }

    public void update_meet(meet me, Integer id) {
        meet mee=meetrepository.getById(id);
        me.setDate(me.getDate());
        me.setLink(me.getLink());
        meetrepository.save(me);
    }

    public void delete_meet(Integer id) {
        meet myMeet = meetrepository.getById(id);
        meetrepository.delete(myMeet);
    }
}