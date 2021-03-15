package furamaResort.commons.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    /**
     * Check whether the input matches with the pattern string.
     *
     * @param input the input string.
     * @param patternString the string pattern.
     * @return true - if the input matches with the pattern string, otherwise false.
     */
    public static boolean isValidInputData(String input, String patternString) {
        // Construct a pattern object from the pattern string.
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
