package com.example.project2.controller;

import com.example.project2.dto.PhoneBookDTO;
import com.example.project2.model.PhoneBook;
import com.example.project2.service.PhoneBookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/name")
    public PhoneBookDTO getPhoneByName(@RequestParam(name = "name") String name){
        return phoneBookService.getPhoneByName(name);
    }

    @GetMapping
    public PhoneBookDTO getPhoneByNumber(@RequestParam(name = "number") String number) {
        return phoneBookService.getPhoneByPhone_number(number);
    }

    @GetMapping("/test")
    public ResponseEntity<List<PhoneBook>> getByNameAndNumber(
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "number", defaultValue = "") String number
    ){
        List<PhoneBook> all = this.phoneBookService.getByNameAndNumber(name, number);

        if(all.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(all, HttpStatus.OK);
    }


    @GetMapping(value = "/all")
    public Page<PhoneBook> getAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        return phoneBookService.getAllPhoneBookEntries(page, size);
    }




}
