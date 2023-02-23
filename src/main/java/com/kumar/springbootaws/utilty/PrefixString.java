package com.kumar.springbootaws.utilty;

public class PrefixString {
    private static String prefix = "";

    public static String prefixUUID(String model) {
        prefix = "";
        for (int i = 0; i < 3; i++) {
            char ch = model.charAt(i);
            prefix = prefix + ch;
            prefix = prefix.toUpperCase();
        }
        return prefix;
    }

    public static String doFormat(String rawString) {
        /*
         * remove all special character and replace white space with +
         *
         */
        String newFormattedString = "";
        for (int i = 0; i < rawString.length(); i++) {
            char charAt = rawString.charAt(i);
            int numberFormat = charAt;
            if ((numberFormat >= 65 && numberFormat <= 122) || (numberFormat >= 97 && numberFormat <= 122)
                    || numberFormat == 32 || (numberFormat >= 48 && numberFormat <= 57)) {
                char ch = rawString.charAt(i);
                if (ch == ' ') {
                    ch = '+';
                }
                newFormattedString += ch;
            }
        }
        return newFormattedString;
    }
}
