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
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import com.example.project2.utils.SerializationUtils;
import com.example.project2.events.PhoneBookEvent;


@Service
@AllArgsConstructor
public class PhoneBookService {

    private final PhoneBookRepository phoneBookRepository;
    private final UserRepository userRepository;
    private final PhoneBookMapper phoneBookMapper;
    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    private static final Logger log = LoggerFactory.getLogger(PhoneBookService.class);

    public PhoneBookDTO addPhone(PhoneBookDTO phoneBookDTO){
        if (phoneBookRepository.findPhoneBookByName(phoneBookDTO.getName()) == null) {
            User user = this.userRepository.findUserById(phoneBookDTO.getUser_id());
            phoneBookDTO.setUser(user);
            PhoneBookDTO savedPhoneBook = phoneBookMapper.toDto(phoneBookRepository.save(phoneBookMapper.toModel(phoneBookDTO)));
            sendPhoneBookEvent("create", savedPhoneBook);
            return phoneBookMapper.toDto(phoneBookRepository.save(phoneBookMapper.toModel(phoneBookDTO)));
        }
        return null;
    }

    private void sendPhoneBookEvent(String eventType, PhoneBookDTO phoneBookDTO) {
        PhoneBookEvent phoneBookEvent = new PhoneBookEvent(eventType, phoneBookDTO);
        byte[] serializedEvent = SerializationUtils.serializePhoneBookEvent(phoneBookEvent);

        if (serializedEvent != null) {
            log.info("Sending phone book event to Kafka: {}", phoneBookEvent);
            kafkaTemplate.send("phoneBookTemplate", serializedEvent);
        } else {
            // Обработка ошибок сериализации, если необходимо
            log.error("Failed to serialize phone book event: {}", phoneBookEvent);
        }
    }


    public List<PhoneBookDTO> getPhoneBooks(){
        return phoneBookMapper.toDtoList(phoneBookRepository.findAll());
    }

    public PhoneBookDTO getPhoneById(Long id){
        return phoneBookMapper.toDto(phoneBookRepository.findPhoneBookById(id));
    }

    @Transactional
    public void deletePhone(Long id){
        PhoneBookDTO deletedPhoneBook = phoneBookMapper.toDto(phoneBookRepository.findPhoneBookById(id));
        phoneBookRepository.deletePhoneBookById(id);
        sendPhoneBookEvent("delete", deletedPhoneBook);
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
        PhoneBookDTO updatedPhoneBook = phoneBookMapper.toDto(phoneBookRepository.save(newPhone));
        sendPhoneBookEvent("update", updatedPhoneBook);

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
