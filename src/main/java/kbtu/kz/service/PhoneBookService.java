package kbtu.kz.service;

import kbtu.kz.domain.dto.PhoneBook.PhoneBookRequest;
import kbtu.kz.domain.model.PhoneBook;
import kbtu.kz.domain.model.User;
import kbtu.kz.repository.PhoneBookRepository;
import kbtu.kz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneBookService {

    private final PhoneBookRepository repository;
    private final UserRepository userRepository;

    public void addPhoneBook(PhoneBookRequest request) {
        if (repository.findPhoneBookByName(request.getName()) != null){
            return;
        }
        User newUser = userRepository.findUserById(request.getUser_id());
        var phoneBook = PhoneBook.builder()
                .name(request.getName())
                .phone_number(request.getPhone_number())
                .b_day(request.getB_day())
                .organization(request.getOrganization())
                .user(newUser)
                .build();
        repository.save(phoneBook);
    }

    public List<PhoneBook> findAll() {
        return repository.findAll();
    }

    public PhoneBook getPhoneBookById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return repository.findPhoneBookById(id);
    }
}
