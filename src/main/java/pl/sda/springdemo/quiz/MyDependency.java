package pl.sda.springdemo.quiz;

import org.springframework.stereotype.Service;

@Service
public class MyDependency {

    public void log() {
        System.out.println("MyDependency::Log");
    }
}
