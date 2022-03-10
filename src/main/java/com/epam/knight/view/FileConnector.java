package com.epam.knight.view;

import com.epam.knight.controller.AmmunitionGenerator;
import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionGeneral;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.Sword;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileConnector {

    private static final String AMMUN_REGEX = "(Sword|Helmet)[{](damage|protection)=\\d+, weight=\\d+, cost=\\d+[}]";
    private static final String FILE_PATH = "src/main/java/com/epam/knight/view/data.txt";
    private static final Pattern INTEGER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern AMMUN_REGEX_PATTERN = Pattern.compile(AMMUN_REGEX);
    private static Knight knight = new Knight();

    public Knight readFromFile()  {
        try {
            for (String itemData : loadData()) {
                addElementFromFile(itemData);
            }
        } catch (IOException e) {
            ConsoleView.fileNotFoundMessage();
        }
        return knight;
    }

    public String[] loadData() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String[] ammunitionData = new String[Knight.AMMUNITION_LENGTH];
            String line = br.readLine();
            for (int i = 0;i < ammunitionData.length && line != null; i++) {
                ammunitionData[i] = line;
                line = br.readLine();
            }
            return ammunitionData;
        }
    }

    private static void addElementFromFile(String element) {
        if (element != null && AMMUN_REGEX_PATTERN.matcher(element).matches()) {
            int[] stats = new int[AmmunitionGeneral.STATS_COUNT];
            Matcher matcher = INTEGER_PATTERN.matcher(element);
            int start = 1;
            int i = 0;
            while (matcher.find(start)) {
                String value = element.substring(matcher.start(), matcher.end());
                stats[i] = Integer.parseInt(value);
                start = matcher.end();
                i++;
            }
            if (element.startsWith("Sword")) {
                knight.equip(AmmunitionGenerator.generateAmmunition(AmmunitionType.HELMET,
                        new int[]{stats[AmmunitionGeneral.COST_INDEX], stats[Sword.DAMAGE_INDEX],
                                stats[AmmunitionGeneral.WEIGHT_INDEX]}));
            } else {
                knight.equip(AmmunitionGenerator.generateAmmunition(AmmunitionType.HELMET,
                        new int[]{stats[AmmunitionGeneral.COST_INDEX], stats[Helmet.PROTECTION_INDEX],
                                stats[AmmunitionGeneral.WEIGHT_INDEX]}));
            }

        }
    }

    public void saveData(Knight knight) {
        try (FileWriter fr = new FileWriter(FILE_PATH, false);
            BufferedWriter writer = new BufferedWriter(fr)) {
            for (Ammunition a: knight.selectCurrentAmmunition()) {
                writer.append(a.toString());
                writer.append(System.lineSeparator());
            }
        } catch (IOException e) {
            ConsoleView.fileNotFoundMessage();
        }
    }

}
