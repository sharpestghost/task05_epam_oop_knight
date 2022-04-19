package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;

import java.util.Arrays;

/**
 * Stores equipped ammunition and calculated stats.
 */
public class Knight {
    public static final int STANDARD_AMMUNITION_LIMIT = 8;
    private static final int ARRAY_LIMIT_MULTIPLIER = 2;
    private int size;
    private int capacity;
    private Ammunition[] ammunition;

    public Knight() {
        capacity = STANDARD_AMMUNITION_LIMIT;
        this.ammunition = new Ammunition[capacity];
        size = 0;
    }

    public Ammunition[] getAmmunition() {
        return ammunition.clone();
    }

    public Ammunition[] selectCurrentAmmunition() {
        return Arrays.copyOf(ammunition, size);
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
        if (size == capacity) {
            increaseAmmunitionLimit();
        }
        ammunition[size] = element;
        size++;
    }

    private void increaseAmmunitionLimit() {
        if (ARRAY_LIMIT_MULTIPLIER * capacity > capacity) {
            capacity *= ARRAY_LIMIT_MULTIPLIER;
            ammunition = Arrays.copyOf(ammunition, capacity);
        } else {
            size--;
        }
    }
}

