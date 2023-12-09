package com.example.project2.service;

import com.example.project2.model.PhoneBook;
import com.example.project2.repository.PhoneBookRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookService {

    @Autowired
    PhoneBookRepository phoneBookRepository;

    public List<PhoneBook> getAll(){
        return this.phoneBookRepository.findAll();
    }

    public PhoneBook save(PhoneBook phoneBook){
        return this.phoneBookRepository.save(phoneBook);
    }

    public PhoneBook getOne(String id){
        return this.phoneBookRepository.getOne(id);
    }

    public String delete(String id){
        this.phoneBookRepository.deleteById(id);
        return "Deleted!";
    }

}
