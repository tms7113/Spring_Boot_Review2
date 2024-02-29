package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Register;

import com.example.demo.repository.RegisterRepo;

@Service
public class RegisterService {
     private RegisterRepo registerrRepo;
      public RegisterService(RegisterRepo registerrRepo)
      {
        this.registerrRepo=registerrRepo;

      }
      public Register saveregister(Register school)
      {
        return registerrRepo.save(school);
      }
      public Register getById(int id)
     {
        
        return registerrRepo.findById(id).orElse(null);
     }
      public List<Register> getAllRegisters()
    {
      return registerrRepo.findAll();
    }
    public boolean updateregister(int id,Register register)
    {
      if(this.getById(id)==null)
      {
         return false;
      }
      try{
         registerrRepo.save(register);
      }
      catch(Exception e)
      {
         return false;
      }
      return true;
    }
    public boolean deleteregister(int id)
    {
      try{
         registerrRepo.deleteById(id);
         return true;
      }
      catch(Exception e)
      {
         return false;
      }
    }

}