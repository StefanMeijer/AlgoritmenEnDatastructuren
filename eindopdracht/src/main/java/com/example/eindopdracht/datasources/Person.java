package com.example.eindopdracht.datasources;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        // Sorteren op leeftijd
        return Integer.compare(this.getAge(), otherPerson.age);
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getAge() + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
