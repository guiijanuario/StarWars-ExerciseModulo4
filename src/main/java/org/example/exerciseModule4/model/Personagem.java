package org.example.exerciseModule4.model;

public class Personagem {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String location;
    private boolean status;

    public Personagem(Long id, String name, int age, String gender, String location, boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = location;
        this.status = status;
    }

    public Personagem(String name, int age, String gender, String location, boolean status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = location;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
