package com.company;

public class Main {

    public static void main(String[] args) {
        Person p = new PersonBuilder()
                .setName("Иван")
                .setSurname("Петров")
                .setAge(36)
                .setAddress("Нижний Новгород")
                .build();

        Person son = p.newChildBuilder()
                .setName("Лёша")
                .build();
        System.out.println("У " + p + " есть сын, " + son);

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-10).build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
