package task3;

import java.util.ArrayList;
import java.util.List;

public class CollectionFilter {
    public static List<String> getUniqueValues(List<String> listOne, List<String> listTwo) {
        List<String> result = new ArrayList<>();
        for (String str : listOne) {
            if (!listTwo.contains(str)) {
                result.add(str);
            }
        }
        return result;
    }
}
