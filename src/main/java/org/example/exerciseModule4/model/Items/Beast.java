package org.example.exerciseModule4.model.Items;

public class Gun extends Items{

    private int maximumAmmoAmount;
    private int damage;
    private int durability;
    public Gun(String name, int maximumAmmoAmount, int damage, int durability) {
        super(name);
        this.maximumAmmoAmount = maximumAmmoAmount;
        this.damage = damage;
        this.durability = durability;
    }
}
