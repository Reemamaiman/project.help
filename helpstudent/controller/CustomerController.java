package com.example.helpstudent.controller;

import com.example.helpstudent.dto.ApiResponse;
import com.example.helpstudent.model.Customer;
import com.example.helpstudent.model.meet;
import com.example.helpstudent.service.customerService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")


public class CustomerController {
    public final customerService customerservice;

    @GetMapping
    public ResponseEntity<List> getcustomer() {
        List<Customer> customer = customerservice.get_Customer();
        return ResponseEntity.status(201).body(customer);
    }

    @PostMapping
    public ResponseEntity addcustomer(@RequestBody @Valid Customer customer) {
        customerservice.add_cust(customer);
        return ResponseEntity.status(200).body(new ApiResponse("customer added !", 200));
    }
        @PutMapping("/{id}")
        public ResponseEntity updatecustomer(@RequestBody @Valid Customer customer, @PathVariable Integer id){
            customerservice.update_cust(customer,id);
            return ResponseEntity.status(200).body(new ApiResponse("Customer updated !", 200));
        }

        @DeleteMapping("/{}")
        public ResponseEntity delete_customer(@PathVariable Integer id) {
            customerservice.delete_cust(id);
            return ResponseEntity.status(200).body(new ApiResponse("user deleted !", 200));

        }


    }


