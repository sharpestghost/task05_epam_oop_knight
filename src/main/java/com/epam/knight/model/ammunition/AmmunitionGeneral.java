package com.epam.knight.model.ammunition;

import java.util.Comparator;

public class AmmunitionGeneral implements Ammunition, Comparable {

    public final static int WEIGHT_INDEX = 0;
    public final static int COST_INDEX = 1;
    public final static int STATS_COUNT = 3;
    private int weight;
    private int cost;
    private AmmunitionType ammunition;


    public AmmunitionGeneral(AmmunitionType ammunition) {
        this.ammunition = ammunition;
    }

    public void setStats(int[] stats) {
        this.weight = stats[WEIGHT_INDEX];
        this.cost = stats[COST_INDEX];
    }


    public AmmunitionType getAmmunition() {
        return ammunition;
    }

    @Override
    final public int getWeight() {
        return weight;
    }

    @Override
    final public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Object a) {
        Ammunition ammunition = (Ammunition) a;
        return this.getWeight() - ammunition.getWeight();
    }
}
