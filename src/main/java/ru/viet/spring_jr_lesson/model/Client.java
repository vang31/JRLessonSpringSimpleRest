package ru.viet.spring_jr_lesson.model;

import java.util.UUID;

public class Client {

    private UUID id;
    private String name;
    private String adress;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return this.adress = adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
