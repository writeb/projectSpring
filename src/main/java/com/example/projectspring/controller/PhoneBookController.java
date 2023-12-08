package com.example.projectspring.controller;

import com.example.projectspring.domain.model.PhoneBook;
import com.example.projectspring.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneBookController {

    @Autowired
    private PhoneBookService service;

    @GetMapping("/phonebooks")
    public List<PhoneBook> findAll() {
        return this.service.findAll();
    }

    @PostMapping("/phonebooks")
    public PhoneBook creatPhoneBook(PhoneBook phoneBook) {
        return this.service.save(phoneBook);
    }

}
