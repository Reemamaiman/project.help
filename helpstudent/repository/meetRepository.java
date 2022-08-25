package com.example.helpstudent.repository;

import com.example.helpstudent.model.meet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface meetRepository extends JpaRepository<meet,Integer> {


}
