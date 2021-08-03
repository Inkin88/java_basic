package task1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Formater {
    public void filter(String source) {
        System.out.println("Введите адрес улицы:");
        Scanner scanner = new Scanner(System.in);
        String streetName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            List<String> list = new ArrayList<>();
            while (reader.ready()) {
                String line = reader.readLine();
                if (!line.startsWith(streetName)) {
                    list.add(line);
                }
            }
            Date currentDate = new Date();
            SimpleDateFormat formatDateNow = new SimpleDateFormat("yyyy.MM.dd");
            BufferedWriter writer = new BufferedWriter(new FileWriter("task_1_addresses_result_"
                    + formatDateNow.format(currentDate) + ".txt"));
            for (String str : list) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
