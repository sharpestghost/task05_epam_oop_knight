package com.epam.knight.model.ammunition;

public class Sword extends AmmunitionGeneral{
    private int damage;
    public static final int DAMAGE_INDEX = 2;

    public Sword() {
        super(AmmunitionType.SWORD);
    }

    public void setStats(int[] stats) {
        super.setStats(stats);
        this.damage = stats[DAMAGE_INDEX];
    }

    public int getDamage() {
        return damage;
    }

    public String toString() {
        return "Sword{damage=" + damage + ", weight=" + getWeight() + ", cost=" + getCost() + "}";
    }

}
