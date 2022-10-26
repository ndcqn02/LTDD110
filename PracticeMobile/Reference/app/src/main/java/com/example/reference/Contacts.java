package com.example.reference;

import java.io.Serializable;

public class Contacts implements Serializable {
    String name;
    String numbers;

    public Contacts(String name, String numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
}
