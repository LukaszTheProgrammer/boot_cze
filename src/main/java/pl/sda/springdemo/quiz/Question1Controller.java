package pl.sda.springdemo.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class Question1Controller {
    //Stworz paczke exercise
    //Umiesc w niej klasę kontrolera, stwórz mapping na dowolna metodę GET
    //Utwórz klasę MyService z metodą drukującą na ekranie "hello"
    //Korzystając z odpowiednich anotacji springa wstrzyknij instancje MyService
    //Wywołaj metodę hello z poziomu metody kontrolera.

    private MyDependency dep;

    @Autowired
    public void setDep(MyDependency dep) {
        this.dep = dep;
    }

    @GetMapping("/path1")
    @ResponseBody
    public String method1(){
        dep.log();
        return "question1/get";
    }

    @PostMapping("/path1")
    @ResponseBody
    public String method2(){
        return "question1/post";
    }
}
