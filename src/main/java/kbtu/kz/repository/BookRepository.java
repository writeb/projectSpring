package kbtu.kz.repository;

import kbtu.kz.domain.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<PhoneBook, Integer> {
}
