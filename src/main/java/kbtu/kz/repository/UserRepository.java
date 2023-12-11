package kbtu.kz.repository;

import java.util.Optional;

import kbtu.kz.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

  User findUserByEmail(String email);

  User findUserById(Integer id);

}
