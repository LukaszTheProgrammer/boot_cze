package pl.sda.springdemo.exercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    MyService myService;

    CmToInchConverter converter;

    public MyController(MyService myService, CmToInchConverter converter) {
        this.myService = myService;
        this.converter = converter;
    }

    @GetMapping("/myctrl")
    public String printHello() {
        return myService.hello();
    }

    @GetMapping("/convert")
    public double printHello(@RequestParam double cm) {
        return converter.convert(cm);
    }
}
