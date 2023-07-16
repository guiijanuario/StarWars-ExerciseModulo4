package org.example.exerciseModule4.model.Items;

public class Stick extends Items{

    private int damage;
    private int durability;

    public Stick(String name, int damage, int durability) {
        super(name);
        this.damage = damage;
        this.durability = durability;
    }
}
