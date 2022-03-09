package com.epam.knight.model.ammunition;

public class AmmunitionGeneral implements Ammunition, Comparable<Ammunition> {

    public static final int WEIGHT_INDEX = 0;
    public static final int COST_INDEX = 1;
    public static final int STATS_COUNT = 3;
    private final AmmunitionType ammunitionType;
    private int weight;
    private int cost;

    public AmmunitionGeneral(AmmunitionType ammunition) {
        this.ammunitionType = ammunition;
    }

    public void setStats(int[] stats) {
        this.weight = stats[WEIGHT_INDEX];
        this.cost = stats[COST_INDEX];
    }

    public AmmunitionType getAmmunition() {
        return ammunitionType;
    }

    @Override
    public final int getWeight() {
        return weight;
    }

    @Override
    public final int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Ammunition other) {
        return this.getWeight() - other.getWeight();
    }

    @Override
    public boolean equals(Object other) {
        return other != null && this.getWeight() == ((Ammunition) other).getWeight();
    }

    @Override
    public int hashCode() {
        return 523 * this.getWeight() - 862 % this.getWeight();
    }

}
