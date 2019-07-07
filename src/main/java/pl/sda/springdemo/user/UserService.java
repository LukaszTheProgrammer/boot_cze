package pl.sda.springdemo.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean create(String email, String password, LocalDate dofB) {
        boolean isEmailTaken = userRepository.findAll().stream()
            .anyMatch(u -> u.getEmail().equals(email));
        if (isEmailTaken) {
            throw new RuntimeException("Email already in use");
        }



        User user = new User(email, password, dofB);
        User created = userRepository.save(user);

        return created.getId() != null;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
