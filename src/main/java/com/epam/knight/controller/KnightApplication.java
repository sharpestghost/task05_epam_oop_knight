package com.epam.knight.controller;

import com.epam.knight.view.FileConnector;

/**
 * Launches main menu with {@link KnightController}.
 */
public class KnightApplication {

    public static void main(String[] args) {
        KnightApplication application = new KnightApplication();
        application.start();
    }

    private void start() {
        KnightController controller = new KnightController();
        controller.callMainMenu();
    }
}
