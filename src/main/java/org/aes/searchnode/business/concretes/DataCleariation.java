package org.aes.searchnode.business.concretes;

public class DataCleariation {
    public String clearData(String text) {
        return text.trim();
    }

    private static final String specialCharacter = "!@#$%^&*()_+{}|\\\"'`~;:/?<>,.-=-`’”“—1234567890[]‘";

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
        for (int i = 0; i < text.length(); i++) {
            if (!(text.charAt(i) >= 'a' && text.charAt(i) <= 'z')) {
                return "";

            }
        }
        return text;
    }

}
