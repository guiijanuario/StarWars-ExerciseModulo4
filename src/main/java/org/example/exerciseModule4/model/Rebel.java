package org.example.exerciseModule4.model;

public class Rebel extends Personagem{
    public Rebel(Long id, String name, int age, String gender, String location, boolean status) {
        super(id, name, age, gender, location, status);
    }

    public Rebel(String name, int age, String gender, String location, boolean status) {
        super(name, age, gender, location, status);
    }



}
