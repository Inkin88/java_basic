package task2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Sorter {
    public void sortByResidents(String source) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            List<Entry> list = new ArrayList<>();
            reader.readLine();
            reader.readLine();
            while (reader.ready()) {
                String line = reader.readLine();
                list.add(new Entry(line));
            }
            list.sort(Comparator.comparing(Entry::getNumberOfResident));
            Date currentDate = new Date();
            SimpleDateFormat formatDateNow = new SimpleDateFormat("yyyy.MM.dd");
            BufferedWriter writer = new BufferedWriter(new FileWriter("task_2_addresses_result_"
                    + formatDateNow.format(currentDate) + ".txt"));
            writer.write("Адрес|Количество жителей|Тип дома" + System.lineSeparator());
            writer.write("_________________________________" + System.lineSeparator());
            for (Entry entry : list) {
                writer.write(entry + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
