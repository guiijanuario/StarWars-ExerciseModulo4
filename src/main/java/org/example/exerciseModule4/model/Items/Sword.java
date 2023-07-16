package org.example.exerciseModule4.model.Items;

public class Sword extends Items{

    private int damage;
    private int durability;

    private String color;

    public Sword(String name, int damage, int durability, String color) {
        super(name);
        this.damage = damage;
        this.durability = durability;
        this.color = color;
    }
}
