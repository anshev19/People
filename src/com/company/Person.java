package com.company;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void happyBirthday() {
        if (hasAge())
            age++;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(surname, 5, address);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        if (hasAge() && hasAddress()) {
            return Objects.hash(name, surname, age, address);
        } else if (hasAge()) {
            return Objects.hash(name, surname, age);
        } else if (hasAddress()) {
            return Objects.hash(name, surname, address);
        } else {
            return Objects.hash(name, surname);
        }
    }
}
