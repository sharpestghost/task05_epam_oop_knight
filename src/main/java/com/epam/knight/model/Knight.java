package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;

/**
 * Stores equipped ammunition and calculated stats.
 */
public class Knight {
    public static final int MAX_AMMUNITION_AMOUNT = 30;
    private int size;
    private Ammunition[] ammunition;

    public Knight() {
        this.ammunition = new Ammunition[MAX_AMMUNITION_AMOUNT];
        size = 0;
    }

    public Ammunition[] getAmmunition() {
        return ammunition.clone();
    }

    public Ammunition[] selectCurrentAmmunition() {
        Ammunition[] selectedAmmunition = new Ammunition[getCurrentSize()];
        int j = 0;
        for (Ammunition value : ammunition) {
            if (value != null) {
                selectedAmmunition[j] = value;
                j++;
            }
        }
        return selectedAmmunition;
    }

    public int getCurrentSize() {
        return size;
    }

    /**
     * Add new ammunition element to knight
     *
     * @param element that should be equipped to the knight
     */
    public void equip(Ammunition element) {
        if (size < MAX_AMMUNITION_AMOUNT) {
            ammunition[size] = element;
        }
    }
}

