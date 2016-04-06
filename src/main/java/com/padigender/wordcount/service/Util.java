package com.padigender.wordcount.service;

import java.text.Normalizer;
import java.util.regex.Pattern;



public class Util {

    /**
     * A simple normalise method that just replaces non alpha numeric characters
     * with spaces and lowercases alphabets.
     *
     * @param str
     * @return
     */
    public static String simpleNormalize(String str) {

        if (null == str)
            return null;

        // Removing following characters
        str = str.replaceAll("[.'‘]", "");

        // Removing accents
        str = removeAccents(str);

        // Tokenising following characters

        str = str.replace("\\", " ");
        str = str.trim().toLowerCase()
                .replaceAll("[°®\\<>`%$=!~+@|?\"*#\\[\\]_/´()&,:;{}-]", " ");
        // str =
        // str.trim().replaceAll("[°®\\<>`%$=!~+@|?\"*#\\[\\]_/´()&,:;{}-]",
        // " ");

        // Replacing multiple spaces with a single space
        str = str.replaceAll("\\s+", " ");

        // Removing all non alpha numeric charachers
        // reason for karayılan murat
        // str = str.trim().replaceAll("[^a-z0-9\\s]", "");

        return str;
    }

    public static String removeAccents(String input) {
        String nfdNormalizedString = Normalizer.normalize(input,
                Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");

    }

}