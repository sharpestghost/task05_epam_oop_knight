package com.epam.knight.model.ammunition;

public interface Ammunition {

    static int WEIGHT_INDEX = 0;
    static int COST_INDEX = 1;
    static int STATS_COUNT = 3;

    int getWeight();

    int getCost();

    void setStats(int[] stats);


}
