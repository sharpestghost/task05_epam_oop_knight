package com.epam.knight.model.ammunition;

public interface Ammunition {

    int WEIGHT_INDEX = 0;
    int COST_INDEX = 1;
    int STATS_COUNT = 3;

    int getWeight();

    int getCost();

    void setStats(int[] stats);


}
