package com.example.helpstudent.repository;


import com.example.helpstudent.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface customerRepository extends JpaRepository<Customer,Integer> {
        Customer findCustomerById(Integer id);
}
