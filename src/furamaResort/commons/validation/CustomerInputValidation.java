package furamaResort.commons.validation;

import java.time.LocalDate;
import java.time.ZoneId;

public class CustomerInputValidation extends InputValidation {

    public static final String CUSTOMER_NAME_PATTERN = "^([A-Z][a-z]+\\s)+([A-Z][a-z]+)$";
    public static final String CUSTOMER_EMAIL_PATTERN = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String CUSTOMER_GENDER_PATTERN = "^(male|female|unknown)$";
    public static final String CUSTOMER_ID_PATTERN = "^(\\d{3}\\s){2}\\d{3}$";
    public static final String CUSTOMER_BIRTHDAY_PATTERN = "^([012]\\d|3[01])/([0][1-9]|[1][012])/(19\\d{2}|[2-9]\\d{3})$";

    /**
     * Check whether the birthday is greater than the current date at least 18 years.
     *
     * @param birthday The birthday in string.
     * @return return true if that is the case, otherwise return false.
     */
    public static boolean isValidCustomerBirthday(String birthday) {
        final long EIGHTEEN_YEARS_IN_MILLIS = (long) (18 * 3.154 * Math.pow(10, 10));

        String[] tokens = birthday.split("/");

        LocalDate birthdayInLocalDate = LocalDate.of(Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[0]));

        // Get the millisecond value of the birthday.
        long birthdayMillis = birthdayInLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        // Get the millisecond value of the current time.
        long currentTimeMillis = System.currentTimeMillis();

        return (currentTimeMillis - birthdayMillis >= EIGHTEEN_YEARS_IN_MILLIS);
    }
}
