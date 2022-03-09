package com.epam.knight.controller;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionGeneral;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.Sword;

/**
 * Generates pieces of {@link Ammunition}.
 */
public final class AmmunitionGenerator {

    private AmmunitionGenerator() {

    }

    public static Ammunition generateAmmunition(AmmunitionType type, int[] stats) {
        Ammunition ammunition;
        switch (type) {
            case HELMET:
                ammunition = new Helmet();
                break;
            case SWORD:
                ammunition = new Sword();
                break;
            default:
                throw new UnsupportedOperationException("Unexpected result");
        }
        ammunition.setStats(stats);
        return ammunition;
    }

}
