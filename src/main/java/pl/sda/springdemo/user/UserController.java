package pl.sda.springdemo.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/users")
    public String createUserForm() {
        return "user/createForm";
    }

    @PostMapping("/users")
    public String addUser(@RequestParam String email, @RequestParam String password,
                          @RequestParam String dateOfBirth,
                          Model model) {
        try {
            LocalDate dofB = LocalDate.parse(dateOfBirth);
            boolean result = userService.create(email, password, dofB);
            List<User> users = userService.findAll();
            model.addAttribute("createUserResult", result);
            model.addAttribute("users", users);

            return "user/list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getLocalizedMessage());

            return "user/createForm";
        }
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam long userId, Model model) {
        userService.delete(userId);
        model.addAttribute("users", userService.findAll());
        model.addAttribute("deleteUserResult", true);

        return "user/list";
    }

    @GetMapping("/users/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());

        return "user/list";
    }
}
