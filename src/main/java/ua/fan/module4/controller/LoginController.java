package ua.fan.module4.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.fan.module4.dto.UserDto;
import ua.fan.module4.model.User;
import ua.fan.module4.service.UserService;


@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login/reset-password")
    public String editUsersPassword(Model model) {
        model.addAttribute("user", new User(" ", " "));
        return "reset_password";
    }

    @PostMapping("/login/reset-password/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser == null) {
            result.rejectValue("email", null,
                    "There is no user with this email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "reset_password";
        }

        userService.updateUsersPassword(userDto);
        return "redirect:/reset-password?success";
    }

}
