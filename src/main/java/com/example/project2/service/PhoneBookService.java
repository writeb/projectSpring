package com.example.project2.service;

import com.example.project2.dto.PhoneBookDTO;
import com.example.project2.mapper.PhoneBookMapper;
import com.example.project2.model.PhoneBook;
import com.example.project2.model.User;
import com.example.project2.repository.PhoneBookRepository;
import com.example.project2.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PhoneBookService {

    private final PhoneBookRepository phoneBookRepository;
    private final UserRepository userRepository;
    private final PhoneBookMapper phoneBookMapper;

    public PhoneBookDTO addPhone(PhoneBookDTO phoneBookDTO){
        if (phoneBookRepository.findPhoneBookByName(phoneBookDTO.getName()) == null) {
//        System.out.println(phoneBookDTO.getUser_id());
            User user = this.userRepository.findUserById(phoneBookDTO.getUser_id());
            phoneBookDTO.setUser(user);
//        System.out.println("PhoneBook User:", );
            return phoneBookMapper.toDto(phoneBookRepository.save(phoneBookMapper.toModel(phoneBookDTO)));
        }
        return null;
    }

    public List<PhoneBookDTO> getPhoneBooks(){
        return phoneBookMapper.toDtoList(phoneBookRepository.findAll());
    }

    public PhoneBookDTO getPhoneById(Long id){
        return phoneBookMapper.toDto(phoneBookRepository.findPhoneBookById(id));
    }

    @Transactional
    public void deletePhone(Long id){
        phoneBookRepository.deletePhoneBookById(id);
    }

    public List<PhoneBook> getByNameAndNumber(String name, String number){
        List<PhoneBook> all = this.phoneBookRepository.findAll();
        List<PhoneBook> res = new ArrayList<PhoneBook>();

        for(PhoneBook phoneBook: all){
            if (phoneBook.getPhone_number().contains(number) && phoneBook.getName().contains(name)){
                res.add(phoneBook);
            }
        }

        return res;

    }

    public PhoneBookDTO updatePhone(Long id, PhoneBookDTO phoneBookDTO){
        PhoneBook newPhone = phoneBookRepository.findPhoneBookById(id);
        newPhone.setPhone_number(phoneBookDTO.getPhone_number());
        newPhone.setName(phoneBookDTO.getName());
        newPhone.setOrganization(phoneBookDTO.getOrganization());
        newPhone.setB_day(phoneBookDTO.getB_day());
        newPhone.setName(phoneBookDTO.getName());

        return phoneBookMapper.toDto(phoneBookRepository.save(newPhone));
    }

    public PhoneBookDTO getPhoneByName(String name){
        return phoneBookMapper.toDto(phoneBookRepository.findPhoneBookByName(name));
    }

    public PhoneBookDTO getPhoneByPhone_number(String number){
        return phoneBookMapper.toDto(phoneBookRepository.findPhoneBookByNumber(number));
    }

    public Page<PhoneBook> getAllPhoneBookEntries(int page, int size){
        PageRequest pageable = PageRequest.of(page, size);
        return phoneBookRepository.findAll(pageable);
    }

}
