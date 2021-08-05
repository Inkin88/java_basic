package task1.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameCreator {
    public static String createFileName(int taskNumber) {
        return String.format("task_%d_addresses_result_%s.txt", taskNumber, getDate());
    }

    public static String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        dateFormat.format(new Date());
        return dateFormat.format(new Date());
    }
}
