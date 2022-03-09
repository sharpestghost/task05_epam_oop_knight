package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.view.FileConnector;

/**
 * Generates knight with some ammunition.
 */
public final class KnightGenerator {

    private KnightGenerator() {

    }

    /**
     * Use it to quickly generate knight
     *
     * @return knight
     */
    public static Knight generateKnight() {
        FileConnector fc = new FileConnector();
        return fc.readFromFile();
    }

}
