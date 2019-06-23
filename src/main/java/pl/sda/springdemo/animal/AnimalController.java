package pl.sda.springdemo.animal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AnimalController {

    private static final Map<Long, Animal> animals = new HashMap<>();

    static {
        animals.put(1L, new Animal(1L, "Jim Beam"));
        animals.put(2L, new Animal(2L, "Filemon"));
        animals.put(3L, new Animal(3L, "Azor"));
    }

    @GetMapping("/animal/{id}")
    public String getAnimal(@PathVariable Long id, Model model) {
        model.addAttribute("animal", animals.get(id));

        return "animal/details";
    }
}
