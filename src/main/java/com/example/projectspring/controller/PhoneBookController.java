package com.example.projectspring.controller;

import com.example.projectspring.domain.dto.PhoneBookUpdateDTO;
import com.example.projectspring.domain.model.PhoneBook;
import com.example.projectspring.service.PhoneBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PhoneBookController {

    @Autowired
    private PhoneBookService service;

    @GetMapping("/phonebooks")
    public List<PhoneBook> findAll() {
        return this.service.findAll();
    }

    @PostMapping("/phonebooks")
    public PhoneBook creatPhoneBook(@RequestBody PhoneBook phoneBook) {
        return this.service.save(phoneBook);
    }

//    @GetMapping("/phonebooks/{id}")
//    public Optional<PhoneBook> getByID(@PathVariable String id){
//        return this.service.one(id);
//    }
//
//    @DeleteMapping("/phonebooks/{id}")
//    public void delete(@PathVariable String id){
//        this.service.deleteById(id);
//    }

//    @PutMapping("/phonebooks/{id}")
//    public PhoneBook update(@RequestBody PhoneBookUpdateDTO phoneBookUpdateDTO, @PathVariable String id){
//        return null;
//    }

//    @GetMapping("/phonebooks_name")
//    public PhoneBook getByName(@RequestBody String name){
//        return this.service.getByName(name);
//    }

}
