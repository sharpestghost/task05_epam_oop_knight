package com.epam.knight.controller;

import com.epam.knight.model.KnightAmmunitionManager;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.view.ConsoleView;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Handles main menu and all operations with knight.
 */
public class KnightController {

    private final int WEIGHT_PICK = 2;
    private final int COST_PICK  = 1;
    private KnightAmmunitionManager knightManager;

    {
        try {
            knightManager = new KnightAmmunitionManager(KnightGenerator.generateKnight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
        for (Ammunition a: knightManager.knight.selectCurrentAmmunition()) {
            if (a != null) {
                ConsoleView.printShowMessage(a);
            }
        }
    }

    public void makeEquipActions() {
        ConsoleView.printEquipMessage();
        int action = ConsoleView.printChooseOption();
        for (AmmunitionType a : AmmunitionType.values()) {
            if (a.getTypeId() == action) {
                int[] stats = ConsoleView.printAmmunitionData(a);
                knightManager.equipAmmunitionToKnight(AmmunitionGenerator.generateAmmunition(a, stats));
            }
        }
    }

    public void makeSortActions() {
        switch (ConsoleView.printSearchMessage()) {
            case WEIGHT_PICK:
                Ammunition[] ammunition = knightManager.knight.selectCurrentAmmunition();
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
        int minValue = ConsoleView.findSearchLimit("minimum weight");
        int maxValue = ConsoleView.findSearchLimit("maximum weight");
        for (Ammunition a: knightManager.searchAmmunitionByWeight(minValue, maxValue)) {
            if (a != null) {
                ConsoleView.printShowMessage(a);
            }
        }
    }

    private void searchByCost() {
        int minValue = ConsoleView.findSearchLimit("minimum cost");
        int maxValue = ConsoleView.findSearchLimit("maximum cost");
        for (Ammunition a: knightManager.searchAmmunitionByCost(minValue, maxValue)) {
            if (a != null) {
                ConsoleView.printShowMessage(a);
            }
        }
    }

    public void makeExitActions() {
        ConsoleView.printExitMessage();
        //save kam to file
    }
}
