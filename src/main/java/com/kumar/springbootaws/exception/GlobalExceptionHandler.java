package com.kumar.springbootaws.exception;


import com.kumar.springbootaws.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> ResourceNotFounfExceptionHandler(ResourceNotFoundException ex) {

        String messg = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(messg, false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(EmailCheckException.class)
//    public ResponseEntity<OTPResponse> EmailCheckExceptionHandler(EmailCheckException ex) {
//
//        String messg = ex.getMessage();
//        OTPResponse otpResponse = new OTPResponse();
//        otpResponse.setMessage("Email Is already Registred!!");
//        otpResponse.setStatus(false);
//        return new ResponseEntity<OTPResponse>(otpResponse, HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
//        Map<String, String> resp = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String message = error.getDefaultMessage();
//            resp.put(fieldName, message);
//        });
//
//        return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(
//            HttpMessageNotReadableException ex) {
//        Map<String, String> resp = new HashMap<>();
//        resp.put("message",
//                "Either Your Time or Date is not following format condition as hh:mm , yyyy-mm-dd respectively !!");
//        return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(ValidationException.class)
//    public ResponseEntity<Map<String, String>> handleValidationException(ValidationException ex) {
//        Map<String, String> resp = new HashMap<>();
//        resp.put("message: ", "Validation Error!!");
//        return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(DBExceptionOccur.class)
    public ResponseEntity<Map<String, String>> handleDBExceptionOccur(DBExceptionOccur ex) {
        Map<String, String> map = new HashMap<>();
        String message = ex.getMessage();
        map.put("message", message);
        return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(RegisterEventEmailException.class)
//    public ResponseEntity<Map<String, String>> handleRegisterEventEmailException(RegisterEventEmailException ex) {
//        Map<String, String> map = new HashMap<>();
//        String message = ex.getMessage();
//        map.put("message", message);
//        return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(InvalidCredentailsException.class)
//    public ResponseEntity<Map<String, String>> handleInvalidCredentailsException(InvalidCredentailsException ex) {
//        Map<String, String> map = new HashMap<>();
//        String message = ex.getMessage();
//        map.put("message", message);
//        return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
//    }

}