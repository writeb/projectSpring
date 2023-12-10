package com.example.project2.repository;

import com.example.project2.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook, Long> {
    PhoneBook deletePhoneBooksByUserId(Long id);
}
