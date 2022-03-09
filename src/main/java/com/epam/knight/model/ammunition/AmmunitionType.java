package com.epam.knight.model.ammunition;

/**
 * Lists different types of ammunition.
 */
public enum AmmunitionType {
    SWORD(1), HELMET(2);

    private final int typeId;

    AmmunitionType(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }
}
