import java.text.SimpleDateFormat;
import java.util.Date;

interface DateUtils {
    static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}