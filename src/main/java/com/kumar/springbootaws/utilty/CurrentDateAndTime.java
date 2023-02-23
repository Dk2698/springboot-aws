package com.kumar.springbootaws.utilty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateAndTime {
    public static String getCurrentDateAndTime() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatedDateTime = current.format(format);
        return formatedDateTime;
    }
}
