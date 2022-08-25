package com.example.helpstudent.service;

import com.example.helpstudent.model.Customer;
import com.example.helpstudent.model.meet;
import com.example.helpstudent.repository.authRepository;
import com.example.helpstudent.repository.customerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service @AllArgsConstructor
public class customerService {
    private final customerRepository customerrepository;
    public final authRepository authrepository;

    public List<Customer> get_Customer() {
        return customerrepository.findAll();
    }

    public void add_cust(Customer cust) {
       customerrepository.save(cust);
    }

    public void update_cust(Customer cust, Integer id) {
        Customer custt=customerrepository.getById(id);
        custt.setAge(cust.getAge());
        custt.setGender(cust.getGender());
        customerrepository.save(cust);
    }




    public void delete_cust(Integer id) {
       Customer Mycustomer = customerrepository.getById(id);
        customerrepository.delete(Mycustomer);
    }
}
