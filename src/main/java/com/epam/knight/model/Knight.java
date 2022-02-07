package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;

/**
 * Stores equipped ammunition and calculated stats.
 */
public class Knight {
    private Ammunition[] ammunition;
    // TODO add fields for knight stats

    public Ammunition[] getAmmunition() {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    /**
     * Add new ammunition element to knight
     *
     * @param element that should be equipped to the knight
     */
    public void equip(Ammunition element) {
        throw new UnsupportedOperationException("You need to implement this method");
    }
}