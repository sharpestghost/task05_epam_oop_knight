package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionGeneral;

import java.util.Arrays;

/**
 * Stores equipped ammunition and calculated stats.
 */
public class Knight {
    public static final int AMMUNITION_LENGTH = 10;
    private Ammunition[] ammunition;

    public Knight() {
        this.ammunition = new Ammunition[AMMUNITION_LENGTH];
    }

    public Ammunition[] getAmmunition() {
        return ammunition.clone();
    }

    public void clearAmmunition() {
        ammunition = new Ammunition[AMMUNITION_LENGTH];
    }

    public Ammunition[] selectCurrentAmmunition() {
        if (getCurrentSize() != 0) {
            Ammunition[] selectedAmmunition = new Ammunition[getCurrentSize()];
            for (int i = 0,j = 0;i < ammunition.length;i++) {
                if (ammunition[i] != null) {
                    selectedAmmunition[j] = ammunition[i];
                    j++;
                }
            }
            return selectedAmmunition;
        } else {
            return null;
        }
    }

    public int getCurrentSize() {
        int size = 0;
        for (Ammunition a: getAmmunition()) {
            if (a != null) {
                size++;
            }
        }
        return size;
    }

    /**
     * Add new ammunition element to knight
     *
     * @param element that should be equipped to the knight
     */
    public void equip(Ammunition element) {
        for (int i = 0;i < ammunition.length;i++) {
            if (ammunition[i] == null) {
                ammunition[i] = element;
                break;
            }
        }
    }
}

