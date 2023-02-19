package ua.fan.module4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.fan.module4.dto.UserDto;
import ua.fan.module4.service.UserService;

import java.util.List;

@Controller
public class ListUsersController {
    private UserService userService;

    @Autowired
    public ListUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "listUsers";
    }
}
