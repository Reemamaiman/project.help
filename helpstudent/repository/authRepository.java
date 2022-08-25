package com.example.helpstudent.repository;



import com.example.helpstudent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authRepository extends JpaRepository<User,Integer> {

        User findUserByUsername(String username);
}
