package com.example.helpstudent.controller;


import com.example.helpstudent.dto.ApiResponse;
import com.example.helpstudent.model.meet;

import com.example.helpstudent.service.meetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/meet")
public class meetController {

    private final meetService meetservice;

    @GetMapping
    public ResponseEntity<List> getmeet() {
        List <meet> meet=meetservice.get_meet();
        return ResponseEntity.status(201).body(meet);
    }

    @PostMapping
    public ResponseEntity add_meet(@RequestBody @Valid meet me){
        meetservice.add_meet(me);
        return ResponseEntity.status(200).body(new ApiResponse("ZOOM added !",200));
    }

    @PutMapping("/{meet}")
    public ResponseEntity update_meet(@RequestBody @Valid meet me,@PathVariable Integer ZOOM){
        meetservice.update_meet(me,ZOOM);
        return ResponseEntity.status(200).body(new ApiResponse("ZOOM updated !",200));
    }

    @DeleteMapping("/{meet}")
    public ResponseEntity delete_meet(@PathVariable Integer ZOOM){
        meetservice.delete_meet(ZOOM);
        return ResponseEntity.status(200).body(new ApiResponse("ZOOM deleted !",200));
    }
}
