package kbtu.kz.service;

import kbtu.kz.domain.dto.PhoneBook.BookRequest;
import kbtu.kz.domain.model.PhoneBook;
import kbtu.kz.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public void save(BookRequest request) {
        var book = PhoneBook.builder()
                .id(request.getId())
                .build();
        repository.save(book);
    }

    public List<PhoneBook> findAll() {
        return repository.findAll();
    }
}
