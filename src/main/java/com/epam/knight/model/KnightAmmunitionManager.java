package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.Sword;

import java.util.Arrays;

/**
 * Manipulates with knight's ammunition and updates knight stats.
 */
public class KnightAmmunitionManager {
    private Knight knight;

    public KnightAmmunitionManager(Knight knight) {
        this.knight = knight;
    }

    public Knight getKnight() {
        return knight;
    }
    /**
     * Equips item to knight and update knight's stats
     */


    public void equipAmmunitionToKnight(Ammunition item) {
        knight.equip(item);
    }

    public void reequipAmmunitionToKnight(Ammunition[] ammunition) {
        knight = new Knight();
        for (Ammunition item: ammunition) {
            equipAmmunitionToKnight(item);
        }
    }

    public int calculateAmmunitionWeight() {
        int weight = 0;
        for (Ammunition a: knight.getAmmunition()) {
            if (a != null) {
                weight += a.getWeight();
            } else {
                break;
            }
        }
        return weight;
    }

    public int calculateAmmunitionCost() {
        int cost = 0;
        for (Ammunition a: knight.getAmmunition()) {
            if (a != null) {
                cost += a.getCost();
            } else {
                break;
            }
        }
        return cost;
    }

    public int calculateAmmunitionDamage() {
        int damage = 0;
        for (Ammunition a: knight.getAmmunition()) {
            if (a instanceof Sword) {
                damage += ((Sword) a).getDamage();
            }
        }
        return damage;
    }

    public int calculateAmmunitionProtection() {
        int protection = 0;
        for (Ammunition a: knight.getAmmunition()) {
            if (a instanceof Helmet) {
                protection += ((Helmet) a).getProtection();
            }
        }
        return protection;
    }

    public Ammunition[] searchAmmunitionByWeight(int minValue, int maxValue) {
        Ammunition[] currentAmmunition = getKnight().selectCurrentAmmunition();
        Ammunition[] selectedAmmunition = new Ammunition[currentAmmunition.length];
        for (int i = 0;i < currentAmmunition.length;i++) {
            if (currentAmmunition[i].getWeight() >= minValue && currentAmmunition[i].getWeight() <= maxValue) {
                selectedAmmunition[i] = currentAmmunition[i];
            }
        }
        return selectedAmmunition.clone();
    }

    public void sortByCost() {
        Ammunition[] ammunition = knight.selectCurrentAmmunition();
        for (int i = ammunition.length - 1; i >= 0; i--) {
            for (int j = i; j < ammunition.length - 1; j++) {
                if (compareCosts(ammunition[j + 1], ammunition[j]) > 0) {
                    Ammunition temp = ammunition[j + 1];
                    ammunition[j + 1] = ammunition[j];
                    ammunition[j] = temp;
                }
            }
        }
        reequipAmmunitionToKnight(ammunition);
    }

    public void sortByWeight() {
        Ammunition[] ammunition = getKnight().selectCurrentAmmunition();
        Arrays.sort(ammunition);
        reequipAmmunitionToKnight(ammunition);
    }

    public int compareCosts(Ammunition a1, Ammunition a2) {
        return a1.getCost() - a2.getCost();
    }

    public Ammunition[] searchAmmunitionByCost(int minValue, int maxValue) {
        Ammunition[] currentAmmunition = knight.getAmmunition();
        int currentSize = knight.getCurrentSize();
        Ammunition[] selectedAmmunition = new Ammunition[currentSize];
        for (int i = 0;i < currentSize;i++) {
            if (currentAmmunition[i].getCost() >= minValue && currentAmmunition[i].getCost() <= maxValue) {
                selectedAmmunition[i] = currentAmmunition[i];
            }
        }
        return selectedAmmunition.clone();
    }


}
