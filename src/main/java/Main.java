import task1.Formater;
import task2.Sorter;
import task3.CollectionFilter;

import java.util.List;

public class Main {

    static List<String> listOne = List.of("Oleg", "Dima", "Masha", "Mira", "Olga");
    static List<String> listTwo = List.of("Oleg", "Mira", "Olga");

    public static void main(String[] args) {
        new Formater().removeStreet("src\\main\\resources\\task_2_addresses.txt");
        new Sorter().sortByResidents("src\\main\\resources\\task_2_addresses.txt");
        System.out.println(CollectionFilter.getUniqueValues(listOne, listTwo));
    }
}
