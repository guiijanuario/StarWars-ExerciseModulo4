package org.example.exerciseModule4.model.Items;

public class Beast extends Items{

    private int maximumAmmoAmount;
    private int damage;
    private int durability;
    public Beast(String name, int maximumAmmoAmount, int damage, int durability) {
        super(name);
        this.maximumAmmoAmount = maximumAmmoAmount;
        this.damage = damage;
        this.durability = durability;
    }
}
