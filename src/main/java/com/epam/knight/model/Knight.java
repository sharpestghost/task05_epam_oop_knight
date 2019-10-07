package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;

public class Knight {

    private Ammunition[] ammunition;

    public Ammunition[] getAmmunition() {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    /**
     * Add new ammunition element to knight
     * @param element that should be equipped to the knight
     */
    public void equip(Ammunition element) {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    public int calculateAmmunitionWeight() {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    public int calculateAmmunitionCost() {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    public int calculateAmmunitionDamage() {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    public int calculateAmmunitionProtection() {
        throw new UnsupportedOperationException("You need to implement this method");
    }

}