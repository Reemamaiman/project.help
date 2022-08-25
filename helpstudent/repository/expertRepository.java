package com.example.helpstudent.repository;

import com.example.helpstudent.model.expert;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface expertRepository extends JpaRepository<expert,Integer> {


}
