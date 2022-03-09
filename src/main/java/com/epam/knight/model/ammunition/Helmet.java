package com.epam.knight.model.ammunition;

public class Helmet extends AmmunitionGeneral {
    public final static int PROTECTION_INDEX = 2;
    private int protection;

    public Helmet() {
        super(AmmunitionType.HELMET);
    }

    public void setStats(int[] stats) {
        super.setStats(stats);
        this.protection = stats[PROTECTION_INDEX];
    }

    public int getProtection() {
        return protection;
    }

    public String toString() {
        return "Helmet{protection=" + protection + ", weight=" + getWeight() + ", cost=" + getCost() + "}";
    }
}
