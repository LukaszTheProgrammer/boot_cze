package pl.sda.springdemo.exercise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ExerciseConfiguration {

    @Bean("myService1")
    @Primary
    public MyService myService1() {
        return () -> "Hi";
    }

    @Bean("myService2")
    public MyService myService2() {
        return () -> "Hola";
    }
   /*
   public interface MyService {

        String hello();
   }
    */
}
