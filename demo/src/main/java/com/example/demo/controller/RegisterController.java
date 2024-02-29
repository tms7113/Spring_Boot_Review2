package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Register;

import com.example.demo.service.RegisterService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class RegisterController {
    private RegisterService registerService;
    public RegisterController(RegisterService registerService)
    {
        this.registerService=registerService;

    }
    @PostMapping("/post/register")
    public Register postMethodName(@RequestBody Register register) {
        return registerService.saveregister(register);
        
    }
    @GetMapping("/get/register/{id}")
    public Register getMethodName(@PathVariable ("id") int id) {
        return registerService.getById(id);
    }
     @GetMapping("/get/register")
    public List<Register> getAllregister()
    {
        return registerService.getAllRegisters();
    }
     @PutMapping("/update/register/{id}")
   public ResponseEntity<Register> putMethod(@PathVariable int id,@RequestBody Register register)
   {
    if(registerService.updateregister(id, register)==true)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
   
   @DeleteMapping("/delete/register/{id}")
   public ResponseEntity<Register> deleteMethod(@PathVariable int id)
   {
    if(registerService.deleteregister(id))
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
    
    
}