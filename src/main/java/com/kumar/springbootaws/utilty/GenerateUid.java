package com.kumar.springbootaws.utilty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateUid {
    private static String valueOf="";

    public static String getUniqueId(String model) {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssns");
        valueOf = current.format(format);
        return PrefixString.prefixUUID(model) + valueOf;
    }
}
