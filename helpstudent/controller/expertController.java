package com.example.helpstudent.controller;


import com.example.helpstudent.dto.ApiResponse;
import com.example.helpstudent.model.expert;
import com.example.helpstudent.service.expertService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/expert")
public class expertController {
 private final expertService expertservice;

  @GetMapping
  public ResponseEntity <List> getPlacee() {
   List <expert> expert=expertservice.get_expert();
   return ResponseEntity.status(201).body(expert);
  }

  @PostMapping
  public ResponseEntity add_expert(@RequestBody @Valid expert ex){
   expertservice.add_expert(ex);
   return ResponseEntity.status(200).body(new ApiResponse("Expert added !",200));
  }

  @PutMapping("/{index}")
  public ResponseEntity update_expert(@RequestBody @Valid expert ex,@PathVariable Integer HR){
   expertservice.update_expert(ex, HR);
   return ResponseEntity.status(200).body(new ApiResponse("HR updated !",200));
  }

  @DeleteMapping("/{index}")
  public ResponseEntity delete_expert(@PathVariable Integer HR){
   expertservice.delete_expert(HR);
   return ResponseEntity.status(200).body(new ApiResponse("HR deleted !",200));
  }
}
