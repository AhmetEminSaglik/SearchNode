package org.aes.searchnode.business.concretes;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.SuccessDataResult;

public class DataCleariation {
    public String trimData(String text) {
        return text.trim();
    }

    private static final String specialCharacter = "!@#$%^&*()_+{}|\\\"'`~;:/?<>,.-=-`’”“—1234567890[]";

    public String removeWildCards(String text) {
        for (int i = 0; i < specialCharacter.length(); i++) {
            text = text.replace(specialCharacter.charAt(i), ' ');
        }
        return text;


    }

    public boolean hasMultipleWords(String text) {
        return text.contains(" ");
    }

    public String removeWordsIfNotBelongsToEnglish(String text) {
//        boolean textUpdated = false;
        for (int i = 0; i < text.length(); i++) {
            int asciiNumberOfChar = text.charAt(i);
            if ((isLowerThan0(asciiNumberOfChar) || isBetween9AndSmallA(asciiNumberOfChar) ||isBetweenSmallZAndBigA(asciiNumberOfChar)|| isGreaterThanBigA(asciiNumberOfChar)) && !isSpace(asciiNumberOfChar)) {
                text = text.replace(text.charAt(i), ' ');
//                textUpdated = true;
            }
        }
    /*    if (textUpdated) {
            return new SuccessDataResult<>(text);
        } else {
            return new ErrorDataResult<>(text);
        }*/

        //48 57     65 90     97 122
//        < 48
//        > 57    <65
//        > 90    < 97
//        > 122
//        < 48
//        < 48
        return text;
    }

    private boolean isLowerThan0(int asciiNum) {
        if (asciiNum < 48)
            return true;
        return false;
    }

    private boolean isBetween9AndSmallA(int asciiNum) {
        if (asciiNum > 57 && asciiNum < 65)
            return true;
        return false;
    }
    private boolean isBetweenSmallZAndBigA(int asciiNum) {
        if (asciiNum > 90 && asciiNum < 97)
            return true;
        return false;
    }

    private boolean isGreaterThanBigA(int asciiNum) {
        if (asciiNum > 122)
            return true;
        return false;
    }

    private boolean isSpace(int asciiNum) {
        if (asciiNum != 32)
            return false;
        return true;

    }

}
