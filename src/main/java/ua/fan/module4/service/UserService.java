package ua.fan.module4.service;

import ua.fan.module4.dto.UserDto;
import ua.fan.module4.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    void updateUsersPassword(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
