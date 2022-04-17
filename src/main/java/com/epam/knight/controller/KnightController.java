package com.epam.knight.controller;

import com.epam.knight.model.KnightAmmunitionManager;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.view.ConsoleView;
import com.epam.knight.view.FileConnector;



/**
 * Handles main menu and all operations with knight.
 */
public class KnightController {
    public static final int WEIGHT_PICK = 2;
    public static final int COST_PICK  = 1;
    private KnightAmmunitionManager knightManager = new KnightAmmunitionManager(KnightGenerator.generateKnight());


    public enum ActionType {
        PRINT(1),
        SHOW(2),
        EQUIP(3),
        SORT(4),
        SEARCH(5),
        EXIT(6),
        ERROR(-1);

        private final int path;

        ActionType(final int path) {
            this.path = path;
        }

        public final int getPath() {
            return path;
        }

    }

    public void callMainMenu() {
        ActionType actionType;
        do {
            actionType = ActionType.ERROR;
            ConsoleView.printStartMessage();
            int action = ConsoleView.selectChooseOption();
            for (ActionType type : ActionType.values()) {
                if (type.getPath() == action) {
                    actionType = type;
                    break;
                }
            }
            performAction(actionType);
        } while (actionType != ActionType.EXIT);
    }

    public void performAction(ActionType actionType) {
        switch (actionType) {
            case PRINT:
                ConsoleView.printKnightStats(knightManager);
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
            case ERROR:
            default:
                ConsoleView.printErrorMessage();
                break;
        }
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
                knightManager.sortByWeight();
                break;
            case COST_PICK:
                knightManager.sortByCost();
                break;
            default:
                break;
        }
        makeShowActions();
    }


    public void makeSearchActions() {
        int stat = ConsoleView.printSearchMessage();
        if (stat == COST_PICK || stat == WEIGHT_PICK) {
            int minValue = ConsoleView.findSearchMinimum(stat);
            int maxValue = ConsoleView.findSearchMaximum(stat);
            Ammunition[] selectedAmmunition;
            if (stat == COST_PICK) {
                selectedAmmunition = knightManager.searchAmmunitionByCost(minValue, maxValue);
            } else {
                selectedAmmunition = knightManager.searchAmmunitionByWeight(minValue, maxValue);
            }
            printSelectedAmmunition(selectedAmmunition);
        }

    }

    private void printSelectedAmmunition(Ammunition[] selectedAmmunition) {
        for (Ammunition item: selectedAmmunition) {
            if (item != null) {
                ConsoleView.printShowAmmunitionItem(item);
            }
        }
    }

    public void makeExitActions() {
        ConsoleView.printExitMessage();
        FileConnector fileConnector = new FileConnector();
        fileConnector.saveData(knightManager.getKnight());
    }
}
