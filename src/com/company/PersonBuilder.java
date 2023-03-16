package com.company;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected Integer age;
    protected String address;

    public PersonBuilder() {
    }

    public PersonBuilder(String surname, int age, String address) {
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalStateException("Age has invalid value");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Name or Surname is needed");
        }

        Person person;

        if (age == null) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }

        if (address != null) {
            person.setAddress(address);
        }

        return person;
    }
}
