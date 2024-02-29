package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sports;
import com.example.demo.service.SportsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class SportsController {
    private SportsService sportsService;
    public SportsController (SportsService sportsService)
    {
        this.sportsService=sportsService;

    }
    @PostMapping("/post/sports")
    public Sports postMethodName(@RequestBody Sports sports) {
        return sportsService.saveSports(sports);
    }
    @GetMapping("/get/sports/{id}")
    public Sports getMethodName(@PathVariable("id") int id) {
        return sportsService.getById(id);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/sports/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Sports>> getMethod(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize, @PathVariable("field") String field) {
        List<Sports> ch = sportsService.getByPaginateSort(offset, pageSize, field);
        if (ch.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ch, HttpStatus.OK);
    }
    @GetMapping("/get/sports")
    public List<Sports> getAllSports()
    {
        return sportsService.getAllSports();
    }
   @PutMapping("/update/sports/{id}")
   public ResponseEntity<Sports> putMethod(@PathVariable int id,@RequestBody Sports sports)
   {
    if(sportsService.updateSports(id, sports)==true)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
   
   @DeleteMapping("/delete/sports/{id}")
   public ResponseEntity<Sports> deleteMethod(@PathVariable int id)
   {
    if(sportsService.deleteSports(id))
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
}