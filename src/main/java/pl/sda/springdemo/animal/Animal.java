package pl.sda.springdemo.animal;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Animal {

    private final Long id;
    private final String name;

    @JsonCreator
    public Animal(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
