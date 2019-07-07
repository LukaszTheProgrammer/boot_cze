package pl.sda.springdemo.exercise;

import org.springframework.stereotype.Component;

@Component
public class HolaService implements MyService{

    @Override
    public String hello() {
        return "Hola";
    }
}
