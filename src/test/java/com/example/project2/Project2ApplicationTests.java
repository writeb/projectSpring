package com.example.project2;

import com.example.project2.dto.UserDTO;
import com.example.project2.mapper.UserMapper;
import com.example.project2.model.Permission;
import com.example.project2.model.PhoneBook;
import com.example.project2.model.User;
import com.example.project2.repository.PermissionRepository;
import com.example.project2.repository.PhoneBookRepository;
import com.example.project2.repository.UserRepository;
import com.example.project2.service.UserMethodsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;


@SpringBootTest
class Project2ApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PhoneBookRepository phoneBookRepository;
	@Autowired
	private UserMethodsService userMethodsService;
	@Autowired
	private PermissionRepository permissionRepository;
	@Autowired
	private UserRepository userRepository;



	@Test
	void contextLoads() {
	}

	@Test
	void checkUserDTO(){
		User user = new User();
		user.setId(555L);
		user.setEmail("ex@gmail.com");
		user.setPassword("1234");
		user.setFullName("Example");

		UserDTO userDTO = userMapper.toDto(user);

		Assertions.assertEquals(user.getId(), userDTO.getId());
		Assertions.assertEquals(user.getEmail(), userDTO.getEmail());
		Assertions.assertEquals(user.getPassword(), userDTO.getPassword());
		Assertions.assertEquals(user.getFullName(), userDTO.getFullName());
	}

	@Test
	void addUserIntoDbAndDelete(){
		User user = new User();
		user.setEmail("tom@gmail.com");
		user.setPassword("qweqwe");
		user.setFullName("Tom");
		List<Permission> permissions = permissionRepository.findPermissionsById(1L);
		user.setPermissions(permissions);

		userRepository.save(user);

//		Assertions.assertNotNull(newUser);
//		Assertions.assertNotNull(newUser.getId());
//		Assertions.assertEquals(user.getEmail(), newUser.getEmail());
//		Assertions.assertEquals(user.getPassword(), newUser.getPassword());
//		Assertions.assertEquals(user.getFullName(), newUser.getFullName());

		User deleteUser = userRepository.findUserById(user.getId());

		if (deleteUser!=null){
			userRepository.deleteById(user.getId());
		}
	}

	@Test
	void changeUserRole(){
		User user1 = new User();
		user1.setEmail("tom@gmail.com");
		user1.setPassword("qweqwe");
		user1.setFullName("Tom");
		List<Permission> permissions = permissionRepository.findPermissionsById(1L);
		user1.setPermissions(permissions);

		User user2 = new User();
		user2.setEmail("ert@gmail.com");
		user2.setPassword("qweqwe");
		user2.setFullName("Erk");
		List<Permission> permissions2 = permissionRepository.findPermissionsById(1L);
		user2.setPermissions(permissions2);

		userRepository.save(user1);
		userRepository.save(user2);

		userMethodsService.changeUserRole(user1.getId(), 2L);

		Assertions.assertNotEquals(user1.getPermissions(), user2.getPermissions());

		User deleteUser1 = userRepository.findUserById(user1.getId());
		User deleteUser2 = userRepository.findUserById(user2.getId());

		if (deleteUser1!=null && deleteUser2!=null){
			userRepository.deleteById(user1.getId());
			userRepository.deleteById(user2.getId());
		}
	}

	@Test
	void addPhoneBookIntoDbAndDelete(){
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.setName("rake");
		phoneBook.setPhone_number("87292");
		phoneBook.setEmail("rake@gmail.com");
		phoneBook.setOrganization("KBTU");
		phoneBook.setB_day(LocalDate.of(2000, 1, 1));
		phoneBook.setUser(userRepository.findUserById(2L));

		phoneBookRepository.save(phoneBook);

		phoneBookRepository.deleteById(phoneBook.getId());
	}







}
