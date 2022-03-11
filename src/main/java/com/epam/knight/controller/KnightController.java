package com.epam.knight.controller;

import com.epam.knight.model.KnightAmmunitionManager;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.view.ConsoleView;
import com.epam.knight.view.FileConnector;

import java.util.Arrays;

/**
 * Handles main menu and all operations with knight.
 */
public class KnightController {
    private static final int WEIGHT_PICK = 2;
    private static final int COST_PICK  = 1;
    private static final String MAXIMUM_WEIGHT = "maximum weight";
    private static final String MINIMUM_WEIGHT = "minimum weight";
    private static final String MAXIMUM_COST = "maximum cost";
    private static final String MINIMUM_COST = "minimum cost";
    private KnightAmmunitionManager knightManager = new KnightAmmunitionManager(KnightGenerator.generateKnight());


    public enum ActionType {
        PRINT(1),
        SHOW(2),
        EQUIP(3),
        SORT(4),
        SEARCH(5),
        EXIT(6);

        private final int path;

        ActionType(final int path) {
            this.path = path;
        }

        public final int getPath() {
            return path;
        }

    }

    public void callMainMenu()  {
        ActionType actionType = ActionType.EXIT;
        ConsoleView.printStartMessage();
        int action = ConsoleView.selectChooseOption();
        for (ActionType type : ActionType.values()) {
            if (type.getPath() == action) {
                actionType = type;
                break;
            }
        }
        switch (actionType) {
            case PRINT:
                makePrintActions();
                break;
            case SHOW:
                makeShowActions();
                break;
            case EQUIP:
                makeEquipActions();
                break;
            case SORT:
                makeSortActions();
                break;
            case SEARCH:
                makeSearchActions();
                break;
            case EXIT:
                makeExitActions();
                return;
            default:
                throw new IllegalStateException("Unexpected value: " + actionType);
        }
    }


    public void makePrintActions() {
        ConsoleView.printKnightStats(knightManager);
    }

    public void makeShowActions() {
        for (Ammunition ammunition: knightManager.getKnight().getAmmunition()) {
            if (ammunition != null) {
                ConsoleView.printShowAmmunitionItem(ammunition);
            }
        }
    }

    public void makeEquipActions() {
        ConsoleView.printEquipMessage();
        int action = ConsoleView.selectChooseOption();
        AmmunitionType type;
        if (AmmunitionType.SWORD.getTypeId() == action) {
            type = AmmunitionType.SWORD;
        } else {
            type = AmmunitionType.HELMET;
        }
        int[] stats = ConsoleView.printAmmunitionData(type);
        knightManager.equipAmmunitionToKnight(AmmunitionGenerator.generateAmmunition(type, stats));
    }

    public void makeSortActions() {
        switch (ConsoleView.printSortMessage()) {
            case WEIGHT_PICK:
                Ammunition[] ammunition = knightManager.getKnight().selectCurrentAmmunition();
                Arrays.sort(ammunition);
                knightManager.reequipAmmunitionToKnight(ammunition);
                break;
            case COST_PICK:
                knightManager.compareByCost();
                break;
            default:
                break;
        }
        makeShowActions();
    }

    public void makeSearchActions() {
        switch (ConsoleView.printSearchMessage()) {
            case WEIGHT_PICK:
                searchByWeight();
                break;
            case COST_PICK:
                searchByCost();
                break;
            default:
                break;
        }

    }

    private void searchByWeight() {
        int minValue = ConsoleView.findSearchLimit(MINIMUM_WEIGHT);
        int maxValue = ConsoleView.findSearchLimit(MAXIMUM_WEIGHT);
        for (Ammunition ammunition: knightManager.searchAmmunitionByWeight(minValue, maxValue)) {
            if (ammunition != null) {
                ConsoleView.printShowAmmunitionItem(ammunition);
            }
        }
    }

    private void searchByCost() {
        int minValue = ConsoleView.findSearchLimit(MINIMUM_COST);
        int maxValue = ConsoleView.findSearchLimit(MAXIMUM_COST);
        for (Ammunition ammunition: knightManager.searchAmmunitionByCost(minValue, maxValue)) {
            if (ammunition != null) {
                ConsoleView.printShowAmmunitionItem(ammunition);
            }
        }
    }

    public void makeExitActions() {
        ConsoleView.printExitMessage();
        FileConnector fileConnector = new FileConnector();
        fileConnector.saveData(knightManager.getKnight());
    }
}
