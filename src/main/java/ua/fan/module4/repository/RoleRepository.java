package ua.fan.module4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.fan.module4.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
