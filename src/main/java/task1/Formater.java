package task1;

import task1.util.FileNameCreator;

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
        writeToFile(filteredByStreet(source));
    }

    private List<String> filteredByStreet(String filePath) {
        System.out.println("Введите адрес улицы:");
        Scanner scanner = new Scanner(System.in);
        String streetName = scanner.nextLine();
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (!line.contains(streetName)) {
                    fileContent.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    private void writeToFile(List<String> dataFromFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileNameCreator.createFileName(1)))) {
            for (String str : dataFromFile) {
                writer.write(str + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
