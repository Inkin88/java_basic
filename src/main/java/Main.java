import task1.Formater;
import task2.Sorter;
import task3.CollectionFilter;

import java.util.List;

public class Main {

    private static String source = "src\\main\\resources\\task_2_addresses.txt";

    static List<String> listOne = List.of("Oleg", "Dima", "Masha", "Mira", "Olga");
    static List<String> listTwo = List.of("Oleg", "Mira", "Olga");

    public static void main(String[] args) {
        new Formater().removeStreet(source);
        new Sorter().sortByResidents(source);
        System.out.println(CollectionFilter.getUniqueValues(listOne, listTwo));
    }
}
