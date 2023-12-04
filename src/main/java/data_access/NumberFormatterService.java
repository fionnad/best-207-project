package data_access;

import java.text.DecimalFormat;

public class NumberFormatterService {

    public static String formatNumber(Object obj) {
        if (obj instanceof Number) {
            double number = ((Number) obj).doubleValue();
            if (number >= 1_000_000 && number < 1_000_000_000) {
                return ((int) (number / 1_000_000)) + " Million";
            } else if (number >= 1_000_000_000 && number < 1_000_000_000_000L) {
                return ((int) (number / 1_000_000_000)) + " Billion";
            } else if (number >= 1_000_000_000_000L) {
                return ((int) (number / 1_000_000_000_000L)) + " Trillion";
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                return decimalFormat.format(number);
            }
        } else {
            return "No Data";
        }
    }
}
