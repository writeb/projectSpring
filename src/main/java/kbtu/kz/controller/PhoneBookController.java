package kbtu.kz.controller;

import kbtu.kz.service.PhoneBookService;
import kbtu.kz.domain.dto.PhoneBook.PhoneBookRequest;
import kbtu.kz.domain.model.PhoneBook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phonebook")
@RequiredArgsConstructor
public class PhoneBookController {

    private final PhoneBookService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PhoneBookRequest request) {
        service.addPhoneBook(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<PhoneBook>> findAllPhoneBooks() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PhoneBook> getPhoneById(@PathVariable(name = "id") Integer id){
        PhoneBook phoneBook  = this.service.getPhoneBookById(id);
        System.out.println(phoneBook);
        if (phoneBook == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(phoneBook, HttpStatus.OK);
    }

}
