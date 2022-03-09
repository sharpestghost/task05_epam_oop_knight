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

        ActionType(int path) {
            this.path = path;
        }

        public int getPath() {
            return path;
        }

    }

    public void callMainMenu()  {
        ConsoleView.printStartMessage();
        int action = ConsoleView.printChooseOption();
        for (ActionType actionType : ActionType.values()) {
            if (actionType.getPath() == action) {
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
        }
        callMainMenu();
    }

    public void makePrintActions() {
        ConsoleView.printKnightStats(knightManager);
    }

    public void makeShowActions() {
        for (Ammunition ammunition: knightManager.getKnight().getAmmunition()) {
            if (ammunition != null) {
                ConsoleView.printShowMessage(ammunition);
            }
        }
    }

    public void makeEquipActions() {
        ConsoleView.printEquipMessage();
        int action = ConsoleView.printChooseOption();
        for (AmmunitionType type : AmmunitionType.values()) {
            if (type.getTypeId() == action) {
                int[] stats = ConsoleView.printAmmunitionData(type);
                knightManager.equipAmmunitionToKnight(AmmunitionGenerator.generateAmmunition(type, stats));
            }
        }
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
                ConsoleView.printShowMessage(ammunition);
            }
        }
    }

    private void searchByCost() {
        int minValue = ConsoleView.findSearchLimit(MINIMUM_COST);
        int maxValue = ConsoleView.findSearchLimit(MAXIMUM_COST);
        for (Ammunition ammunition: knightManager.searchAmmunitionByCost(minValue, maxValue)) {
            if (ammunition != null) {
                ConsoleView.printShowMessage(ammunition);
            }
        }
    }

    public void makeExitActions() {
        ConsoleView.printExitMessage();
        FileConnector fileConnector = new FileConnector();
        fileConnector.saveData(knightManager.getKnight());
    }
}
