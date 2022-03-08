package com.epam.knight.view;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.AmmunitionType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileConnector {

    private static Knight knight = new Knight();
    private static final String NEWLINE = "\n";
    private static final String AMMUNITION_REGEX = "(Sword|Helmet){(damage|protection)=\\d+, weight=\\d+, cost=\\d+}";

    public Knight readFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("data.txt");
        String data = readFromInputStream(inputStream);
        transformTextToAmmunitionArray(data);
        return null;
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    private static void transformTextToAmmunitionArray(String data) {
        String[] fileData = data.split("\n");
        for (String element: fileData) {
            if (element.matches(AMMUNITION_REGEX)) {
                addElementFromFile(element);
            }
        }
    }

    private static void addElementFromFile(String element) {
        AmmunitionType type = (element.startsWith("Sword")) ? AmmunitionType.SWORD : AmmunitionType.HELMET;
        String[] statArray = element.split("\\D");
        int[] array = new int[3];

    }

}
