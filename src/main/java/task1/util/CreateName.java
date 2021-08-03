package task1.util;

public class CreateName {
    public static String createFileNameForTask1() {
        return "task_1_addresses_result_" + getDate() + ".txt";
    }

    public static String createFileNameForTask2() {
        return "task_2_addresses_result_" + getDate() + ".txt";
    }

    public static String getDate() {
        return Constants.DATE_FORMAT.format(Constants.CURRENT_DATE);
    }
}
