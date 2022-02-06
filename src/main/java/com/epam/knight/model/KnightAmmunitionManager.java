package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;

/**
 * Manipulates with knight's ammunition and updates knight stats.
 */
public class KnightAmmunitionManager {
   private Knight knight;

   public KnightAmmunitionManager(Knight knight) {
      this.knight = knight;
   }

   /**
    * Equips item to knight and update knight's stats
    */
   public void equipAmmunitionToKnight(Ammunition item) {
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
