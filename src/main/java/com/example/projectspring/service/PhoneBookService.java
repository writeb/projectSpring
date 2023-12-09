package com.example.projectspring.service;

import com.example.projectspring.domain.model.PhoneBook;
import com.example.projectspring.repository.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PhoneBookService  {

    @Autowired
    private PhoneBookRepository repo;

    public List<PhoneBook> findAll() {
        return this.repo.findAll();
    }

    public PhoneBook save(PhoneBook phoneBook) {
        return this.repo.save(phoneBook);
    }

//    public Optional<PhoneBook> one(String id){
//        return this.repo.findById(id);
//    }
//
//    public void deleteById(String id) {
//        this.repo.deleteById(id);
//    }
//
//    public PhoneBook getByName(String name) {
//        List<PhoneBook> all = this.repo.findAll();
//
//        for (PhoneBook phone: all){
//            if (phone.getName() == name){
//                return phone;
//            }
//        }
//        return null;
//    }

//    public PhoneBook update()

}
