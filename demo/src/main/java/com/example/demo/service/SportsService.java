package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sports;
import com.example.demo.repository.SportsRepo;

@Service
public class SportsService {
    private SportsRepo sportsRepo;
     public SportsService(SportsRepo sportsRepo)
     {
        this.sportsRepo=sportsRepo;
     }
     public Sports saveSports(Sports sports)
     {
        return sportsRepo.save(sports);
     }
     public Sports getById(int id)
     {
        return sportsRepo.findById(id).orElse(null);
     }
     public List<Sports> getByPaginateSort(int offset, int pageSize, String field) {
        Page<Sports> pg = sportsRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
        return pg.getContent();
    }
    public List<Sports> getAllSports()
    {
      return sportsRepo.findAll();
    }
    public boolean updateSports(int id,Sports sports)
    {
      if(this.getById(id)==null)
      {
         return false;
      }
      try{
         sportsRepo.save(sports);
      }
      catch(Exception e)
      {
         return false;
      }
      return true;
    }
    public boolean deleteSports(int id)
    {
      try{
         sportsRepo.deleteById(id);
         return true;
      }
      catch(Exception e)
      {
         return false;
      }
    }

}