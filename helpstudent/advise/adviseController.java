package com.example.helpstudent.advise;

import com.example.helpstudent.dto.ApiException;
import com.example.helpstudent.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class adviseController {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        String message = methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(200).body(new ApiResponse(message, 400));
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<ApiResponse> HttpClientErrorException(HttpClientErrorException HttpClientErrorException) {
        String message = HttpClientErrorException.getMessage();
        return ResponseEntity.status(200).body(new ApiResponse("not found", 400));
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> apiException(ApiException apiException) {
        String message = apiException.getMessage();
        return ResponseEntity.status(200).body(new ApiResponse(message, 400));


    }
}
