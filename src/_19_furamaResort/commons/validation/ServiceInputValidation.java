package furamaResort.commons.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceInputValidation extends InputValidation {

    public static final String VILLA_ID_PATTERN = "^SVVL-[0-9]{4}$";
    public static final String HOUSE_ID_PATTERN = "^SVHO-[0-9]{4}$";
    public static final String ROOM_ID_PATTERN = "^SVRO-[0-9]{4}$";
    public static final String NAME_PATTERN = "^[A-Z]{1}[a-z]{1,}$";
    public static final String AREA_PATTERN = "^([3-9]\\d*)(\\.\\d+)?$"; // "^[0-9]+[.]?\\d+$"
    public static final String PRICE_PATTERN = "^([1-9]\\d*)(\\.\\d+)?$";
    public static final String LARGEST_GUEST_NUMBER_PATTERN = "^([1-9]|1\\d?)$";
    public static final String ANOTHER_UTILITY_PATTERN = "^(massage|karaoke|food|drink|car)$";
    public static final String NUMBER_OF_FLOORS_PATTERN = "^([1-9]\\d*)$";
}
