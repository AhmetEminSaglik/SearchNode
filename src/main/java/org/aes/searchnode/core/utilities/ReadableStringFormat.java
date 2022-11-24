package org.aes.searchnode.core.utilities;

public class ReadableStringFormat {
    public static String getReadableValueIntToString(int num) {
        String text = "";
        int j = 0;
        while (num > 0) {
            text = num % 10 + text;
            num /= 10;
            j++;
            if (j % 3 == 0 && num > 0) {
                text = "_" + text;
            }

        }
        return text;

    }

    public static String getReadableValueLongToString(long num) {
        String text = "";
        int j = 0;
        while (num > 0) {
            text = num % 10 + text;
            num /= 10;
            j++;
            if (j % 3 == 0 && num > 0) {
                text = "_" + text;
            }

        }
        return text;

    }

}
