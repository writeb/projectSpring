package kbtu.kz.repository;

import kbtu.kz.domain.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookRepository extends JpaRepository<PhoneBook, Integer> {

    PhoneBook findPhoneBookById(Integer id);
    PhoneBook findPhoneBookByName(String name);
}
