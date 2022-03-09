package com.epam.knight.view;

import com.epam.knight.model.KnightAmmunitionManager;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.model.ammunition.Sword;
import com.epam.knight.model.ammunition.Helmet;

import java.util.Locale;
import java.util.Scanner;

/**
 * Implements all application input and output.
 */
public final class ConsoleView {



    private static final String MENU_MESSAGE = "Main menu:\n" +
            "1. Print knight stats\n" +
            "2. Show ammunition\n" +
            "3. Equip ammunition\n" +
            "4. Sort ammunition\n" +
            "5. Search ammunition\n" +
            "6. Exit";
    private static final String CHOOSE_OPTION = "Choose option:";
    private static final String PRINT_STATS = "Ammunition cost: %d\nAmmunition weight: %d\n" +
            "Ammunition damage: %d\nAmmunition protection: %d\n";
    private static final String EQUIP_MENU = "What kind of ammunition do you want to equip?\n1. Sword\n2. Helmet";
    private static final String SORT_MENU = "Choose sort type:\n1. Cost\n2. Weight";
    private static final String SEARCH_MENU = "Choose search field:\n1. Cost\n2. Weight";
    private static final String INPUT_WITH_ONE_PARAMETER = "Input %s :%n";
    private static final String INPUT_WITH_TWO_PARAMETERS  = "Input %s %s:%n";
    private static final String EXIT_MESSAGE = "Bye!";
    private static final String FILE_NOT_FOUND = "File is not found";
    private static final String WEIGHT = "weight";
    private static final String COST = "cost";
    private static final String DAMAGE = "damage";
    private static final String ARMOR = "protection";

    private static Scanner scanner = new Scanner(System.in);

    private ConsoleView() {

    }

    public static void printStartMessage() {
        System.out.println(MENU_MESSAGE);
    }

    public static int printChooseOption() {
        System.out.println(CHOOSE_OPTION);
        return scanner.nextInt();
    }

    public static void printKnightStats(KnightAmmunitionManager knight) {
        System.out.printf(PRINT_STATS, knight.calculateAmmunitionCost(), knight.calculateAmmunitionWeight(),
                knight.calculateAmmunitionDamage(),knight.calculateAmmunitionProtection());
    }

    public static void printShowMessage(Ammunition a) {
        System.out.println(a.toString());
    }

    public static void printEquipMessage() {
        System.out.println(EQUIP_MENU);
    }

    public static int[] printAmmunitionData(AmmunitionType ammunitionType) {
        int weight = printAmmunitionStat(ammunitionType, WEIGHT);
        int cost = printAmmunitionStat(ammunitionType, COST);
        int[] stats = new int[] {weight, cost, 0};
        switch (ammunitionType) {
            case SWORD:
                Sword sword = new Sword();
                stats[Sword.DAMAGE_INDEX] = printAmmunitionStat(ammunitionType, DAMAGE);
                sword.setStats(stats);
                break;
            case HELMET:
                Helmet helmet = new Helmet();
                stats[Helmet.PROTECTION_INDEX] = printAmmunitionStat(ammunitionType, ARMOR);
                helmet.setStats(stats);
                break;
            default:
                break;
        }
        return stats;
    }

    private static int printAmmunitionStat(AmmunitionType ammunitionType, String statName) {
        System.out.printf(INPUT_WITH_TWO_PARAMETERS, ammunitionType.toString().toLowerCase(Locale.UK), statName);
        return scanner.nextInt();
    }


    public static int printSortMessage() {
        System.out.println(SORT_MENU);
        return scanner.nextInt();
    }

    public static int printSearchMessage() {
        System.out.println(SEARCH_MENU);
        return scanner.nextInt();
    }

    public static int findSearchLimit(String message) {
        System.out.printf(INPUT_WITH_ONE_PARAMETER, message);
        return scanner.nextInt();
    }

    public static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    public static void fileNotFoundMessage() {
        System.out.println(FILE_NOT_FOUND);
    }


}
