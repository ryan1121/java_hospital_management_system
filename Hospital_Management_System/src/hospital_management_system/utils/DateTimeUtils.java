package hospital_management_system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateTimeUtils {
    public static String formatDate(String dateStr) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(dateStr);
            return outputFormat.format(date);
        } catch (ParseException e) {
            // e.printStackTrace();
            return null;
        }
    }
    
    public static String formatTime(String timeStr) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm a");
            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
            Date time = inputFormat.parse(timeStr);
            return outputFormat.format(time);
        } catch (ParseException e) {
            return null;
        }
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Method to add months to a date
    public static String addMonths(String dateStr, int months) {
        // Check for null or empty input
        if (dateStr == null || dateStr.isEmpty()) {
            throw new IllegalArgumentException("Date string cannot be null or empty.");
        }
    
        // Validate the date format before parsing
        if (!isValidDateFormat(dateStr)) {
            throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd.");
        }
    
        // Parse and add months
        LocalDate localDate = LocalDate.parse(dateStr, DATE_FORMATTER);
        LocalDate newDate = localDate.plusMonths(months);
    
        return newDate.format(DATE_FORMATTER);
    }
    

    // Method to validate the date format
    private static boolean isValidDateFormat(String dateStr) {
        try {
            LocalDate.parse(dateStr, DATE_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
