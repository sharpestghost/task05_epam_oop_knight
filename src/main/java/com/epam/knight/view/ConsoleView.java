package com.epam.knight.view;

import com.epam.knight.controller.KnightController;
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
    private static final String INPUT_MINIMUM = "Input minimum %s:%n";
    private static final String INPUT_MAXIMUM = "Input maximum %s:%n";
    private static final String INPUT_WITH_TWO_PARAMETERS  = "Input %s %s:%n";
    private static final String EXIT_MESSAGE = "Bye!";
    private static final String ERROR_MESSAGE = "No results found.";
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

    public static int selectChooseOption() {
        printSelectOptionMessage();
        return scanner.nextInt();
    }

    public static void printKnightStats(KnightAmmunitionManager knight) {
        System.out.printf(PRINT_STATS, knight.calculateAmmunitionCost(), knight.calculateAmmunitionWeight(),
                knight.calculateAmmunitionDamage(),knight.calculateAmmunitionProtection());
    }

    public static int[] getAmmunitionData(AmmunitionType ammunitionType) {
        int weight = getAmmunitionStat(ammunitionType, WEIGHT);
        int cost = getAmmunitionStat(ammunitionType, COST);
        int[] stats = new int[] {weight, cost, 0};
        switch (ammunitionType) {
            case SWORD:
                stats[Sword.DAMAGE_INDEX] = getAmmunitionStat(ammunitionType, DAMAGE);
                break;
            case HELMET:
                stats[Helmet.PROTECTION_INDEX] = getAmmunitionStat(ammunitionType, ARMOR);
                break;
            default:
                break;
        }
        return stats;
    }

    private static int getAmmunitionStat(AmmunitionType ammunitionType, String statName) {
        printAmmunitionStat(ammunitionType, statName);
        return scanner.nextInt();
    }


    public static int findSortOption() {
        printSortMessage();
        return scanner.nextInt();
    }

    public static int findSearchOption() {
        printSearchMessage();
        return scanner.nextInt();
    }

    public static int findSearchMinimum(int selectedItem) {
        printSearchItemMessage(INPUT_MINIMUM, selectedItem);
        return scanner.nextInt();
    }
    public static int findSearchMaximum(int selectedItem) {
        printSearchItemMessage(INPUT_MAXIMUM, selectedItem);
        return scanner.nextInt();
    }

    private static void printSearchItemMessage(String itemMessage, int selectedItem) {
        System.out.printf(itemMessage, getStatName(selectedItem));
    }

    private static String getStatName(int selectedItem) {
        String statName;
        if (selectedItem == KnightController.COST_PICK) {
            statName = COST;
        } else {
            statName = WEIGHT;
        }
        return statName;
    }

    private static void printSelectOptionMessage() {
        System.out.println(CHOOSE_OPTION);
    }

    public static void printShowAmmunitionItem(Ammunition item) {
        System.out.println(item.toString());
    }

    public static void printEquipMessage() {
        System.out.println(EQUIP_MENU);
    }

    public static void printAmmunitionStat(AmmunitionType ammunitionType, String statName) {
        System.out.printf(INPUT_WITH_TWO_PARAMETERS, ammunitionType.toString().toLowerCase(Locale.UK), statName);
    }

    public static void printSortMessage() {
        System.out.println(SORT_MENU);
    }

    public static void printSearchMessage() {
        System.out.println(SEARCH_MENU);
    }

    public static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    public static void printErrorMessage() {
        System.out.println(ERROR_MESSAGE);
    }

    public static void fileNotFoundMessage() {
        System.out.println(FILE_NOT_FOUND);
    }


}
