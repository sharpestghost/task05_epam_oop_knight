package com.epam.knight.view;

import com.epam.knight.model.KnightAmmunitionManager;
import com.epam.knight.model.ammunition.*;

import java.util.Scanner;

/**
 * Implements all application input and output.
 */
public class ConsoleView {


//через енамы сделать
    private static Scanner scanner = new Scanner(System.in);

    public static void printStartMessage() {
        System.out.println("Main menu:\n" +
                "1. Print knight stats\n" +
                "2. Show ammunition\n" +
                "3. Equip ammunition\n" +
                "4. Sort ammunition\n" +
                "5. Search ammunition\n" +
                "6. Exit");
    }

    public static int printChooseOption() {
        System.out.println("Choose option:");
        int action = scanner.nextInt();
        System.out.println(action);
        return action;
    }

    public static void printKnightStats(KnightAmmunitionManager knight) {
        System.out.printf("Ammunition cost: %d\nAmmunition weight: %d\n" +
                        "Ammunition damage: %d\nAmmunition protection: %d\n",
                knight.calculateAmmunitionCost(), knight.calculateAmmunitionWeight(),
                knight.calculateAmmunitionDamage(),knight.calculateAmmunitionProtection());
    }

    public static void printShowMessage(Ammunition a) {
        System.out.println(a.toString());
    }

    public static void printEquipMessage() {
        System.out.println("What kind of ammunition do you want to equip?\n" +
                "1. Sword\n2. Helmet");
    }

    public static int[] printAmmunitionData(AmmunitionType ammunitionType) {
        int weight = printAmmunitionStat(ammunitionType, "weight");
        int cost = printAmmunitionStat(ammunitionType, "cost");
        int[] stats = new int[] {weight, cost, 0};
        switch (ammunitionType) {
            case SWORD:
                Sword sword = new Sword();
                stats[Sword.DAMAGE_INDEX] = printAmmunitionStat(ammunitionType, "damage");
                sword.setStats(stats);
                break;
            case HELMET:
                Helmet helmet = new Helmet();
                stats[Helmet.PROTECTION_INDEX] = printAmmunitionStat(ammunitionType, "protection");
                helmet.setStats(stats);
                break;
            default:
                throw new UnsupportedOperationException("Unexpected result");
        }
        return stats;
    }

    private static int printAmmunitionStat(AmmunitionType ammunitionType, String statName) {
        System.out.printf("Input %s %s:\n", ammunitionType.toString().toLowerCase(), statName);
        return scanner.nextInt();
    }


    public static void printSortMessage() {
       System.out.println("Choose sort type:" +
               "\n1. Cost\n2. Weight");
    }

    public static int printSearchMessage() {
        System.out.println("Choose search field:" +
                "\n1. Cost\n2. Weight");
        return scanner.nextInt();
    }

    public static int findSearchLimit(String message) {
        System.out.printf("Input %s:\n", message);
        return scanner.nextInt();
    }

    public static void printExitMessage() {
        System.out.println("bye");
    }













}
