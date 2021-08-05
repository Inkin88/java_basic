package task2;

import task1.util.FileNameCreator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorter {
    public void sortByResidents(String source) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FileNameCreator.createFileName(2)))) {
            List<AdressEntry> list = new ArrayList<>();
            reader.readLine();
            reader.readLine();
            while (reader.ready()) {
                String line = reader.readLine();
                list.add(new AdressEntry(line));
            }
            list.sort(Comparator.comparing(AdressEntry::getNumberOfResident));
            writer.write("Адрес|Количество жителей|Тип дома" + System.lineSeparator());
            writer.write("_________________________________" + System.lineSeparator());
            for (AdressEntry entry : list) {
                writer.write(entry + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
