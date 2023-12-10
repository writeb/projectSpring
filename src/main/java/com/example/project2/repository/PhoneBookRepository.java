package com.example.project2.repository;

import com.example.project2.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook, Long> {

    void deletePhoneBookById(Long id);
    PhoneBook findPhoneBookById(Long id);

    PhoneBook findPhoneBookByName(String name);

    @Query("SELECT ph FROM PhoneBook ph WHERE ph.phone_number = :phone_number")
    PhoneBook findPhoneBookByNumber(@Param("phone_number") String phone_number);
}
