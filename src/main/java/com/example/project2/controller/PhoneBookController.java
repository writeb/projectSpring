package com.example.project2.controller;

import com.example.project2.model.PhoneBook;
import com.example.project2.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneBookController {

    @Autowired
    PhoneBookService phoneBookService;

    @PostMapping("/phonebooks")
    public PhoneBook create(@RequestBody PhoneBook phoneBook){
        return this.phoneBookService.save(phoneBook);
    }


    @GetMapping("/phonebooks")
    public List<PhoneBook> getAll(){
        return this.phoneBookService.getAll();
    }

    @GetMapping("/phonebooks/{id}")
    public PhoneBook getOne(@PathVariable String id){
        return this.phoneBookService.getOne(id);
    }

    @DeleteMapping("/phonebooks/{id}")
    public String delete(@PathVariable String id){
        return this.phoneBookService.delete(id);
    }



}
