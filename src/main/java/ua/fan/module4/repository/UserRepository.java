package ua.fan.module4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.fan.module4.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    void deleteUserByEmail(String emai);
}
