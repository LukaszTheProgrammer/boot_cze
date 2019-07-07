package pl.sda.springdemo.quiz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Question8Controller {

    @GetMapping("/path8")
    public String method1(@RequestParam Long id, @RequestParam String name) {

        return "question8/get/"+id+"/"+name;
    }
}
