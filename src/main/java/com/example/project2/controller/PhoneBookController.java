package com.example.project2.controller;

import com.example.project2.dto.PhoneBookDTO;
import com.example.project2.service.PhoneBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
@AllArgsConstructor
public class PhoneBookController {

    private final PhoneBookService phoneBookService;

    @PostMapping
    public PhoneBookDTO addPhone(@RequestBody PhoneBookDTO phoneBookDTO){
        return phoneBookService.addPhone(phoneBookDTO);
    }

    @GetMapping(value = "/{id}")
    public PhoneBookDTO getPhone(@PathVariable(name = "id") Long id){
        return phoneBookService.getPhoneById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePhone(@PathVariable(name = "id") Long id){
        phoneBookService.deletePhone(id);
    }

    @PutMapping(value = "/{id}")
    public PhoneBookDTO updatePhone(@PathVariable(name = "id") Long id,
                                    @RequestBody PhoneBookDTO phoneBookDTO){
        return phoneBookService.updatePhone(id, phoneBookDTO);
    }

    @GetMapping(value = "/name/{name}")
    public PhoneBookDTO getPhoneByName(@PathVariable(name = "name") String name){
        return phoneBookService.getPhoneByName(name);
    }

    @GetMapping(value = "/num/{num}")
    public PhoneBookDTO getPhoneByNumber(@PathVariable(name = "num") String number){
        return phoneBookService.getPhoneByPhone_number(number);
    }




}
