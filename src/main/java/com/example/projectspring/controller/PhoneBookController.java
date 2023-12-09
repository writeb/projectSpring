package com.example.projectspring.controller;

import com.example.projectspring.domain.dto.PhoneBookCreateDTO;
import com.example.projectspring.domain.model.PhoneBook;
import com.example.projectspring.domain.model.User;
import com.example.projectspring.service.PhoneBookService;
import com.example.projectspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PhoneBookController {

    @Autowired
    private PhoneBookService service;

    @Autowired
    private UserService userService;

    @GetMapping("/phonebooks")
    public List<PhoneBook> findAll() {
        return this.service.findAll();
    }

    @PostMapping("/phonebooks")
    public PhoneBook creatPhoneBook(@RequestBody PhoneBookCreateDTO phoneBook) {
        User user = this.userService.getUserByID(phoneBook.user_id);

        PhoneBook phone = new PhoneBook();
        phone.setName(phoneBook.getName());
        phone.setAddress(phoneBook.getAddress());
        phone.setPhone_number(phoneBook.getPhone_number());
        phone.setOrganization(phoneBook.getOrganization());
        phone.setUser(user);
        phone.setB_day(phoneBook.getB_day());
        phone.setEmail(phoneBook.getEmail());

        return this.service.save(phone);
    }

}
