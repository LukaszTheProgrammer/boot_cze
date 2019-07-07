package pl.sda.springdemo.exercise;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguegeController {

    private String langs;

    public LanguegeController(@Value("${app.languages:eng}") String langs) {
        this.langs = langs;
    }

    @GetMapping("/langs")
    public String langs() {
        String[] languages = langs.split(",");

        return Stream.of(languages)
            .map(l -> "- " + l)
            .collect(Collectors.joining("<br/>"));
    }
}
