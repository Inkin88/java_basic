package task1;

import task1.util.CreateName;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Formater {
    public void removeStreet(String source) {
        System.out.println("Введите адрес улицы:");
        Scanner scanner = new Scanner(System.in);
        String streetName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(CreateName.createFileNameForTask1()))) {
            List<String> list = new ArrayList<>();
            while (reader.ready()) {
                String line = reader.readLine();
                if (!line.contains(streetName)) {
                    list.add(line);
                }
            }
            for (String str : list) {
                writer.write(str + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
