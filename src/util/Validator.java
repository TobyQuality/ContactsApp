package util;

import java.time.LocalDate;
/**
 * Validation class is used in the Contact class's set methods.
 * 
 * The main function of the class is to call methods
 * for different validations (id, address etc.).
 * The validations are done by utilizing mainly regular expressions.
 * The validations make sure that the correct form
 * required is given as an input in the text fields)
 * 
 * @author Topias Laatu
 */
public class Validator {

    /**
     * Used for validating id.
     * 
     * The ID pattern follows Finnish ID model.
     * The first validation test tests if the id given as parameter
     * follows the general form of an ID.
     * The second validation checks the validity of the day
     * The third validation checks the validity of the month
     * The fourth validation checks the validity of the leap year
     * The fifth validation checks the validity of the individual number
     * In the sixth validation the numbers (9 digits) of the ID
     * are merged, then a modulo operation of [9 digits] mod 31 is performed.
     * Check digits array contains digits, their index numbers
     * correspond with the modulo operations results.
     * 
     * @param id
     * @return boolean value contained in variable "valid".
     */
    public boolean validateId(String id) {
        boolean firstValidation = false;
        boolean secondValidation = false;
        boolean thirdValidation = false;
        boolean fourthValidation = false;
        boolean fifthValidation = false;
        boolean sixthValidation = false;
        boolean valid = false;
        
        //first validation = checking if the id has right character types
        //and if it has 11 characters
        String rightCharacters = "\\d{6}[-A]\\d{3}[0-9A-FHJ-OPR-Y]";
        if (id.matches(rightCharacters)) {
            firstValidation = true;
        }
        
        //second validation = checking the validity of day
        if (firstValidation) {
            //in the third validation the second
            //digit's validity is checked based on
            //the preceding digit. For example, if the first
            //digit is 3 and the second is 9
            //that would make the Id a fake,
            //since there is no day number
            //corresponding with 39 in any month
            String day = id.substring(0,2);
            boolean pass = false;

            //if the first digit is 1 or 2, then they automatically
            //pass the test, since the second digit dont need
            //checking, since they are automatically something
            //between 0-9, which has been validated previously
            if (id.charAt(0) == '1' || id.charAt(0) == '2') {
                pass = true;
            }

            if (id.charAt(0) == '0') {
                String regEx= "0[1-9]";
                if (day.matches(regEx)) {
                    pass = true;
                }
            }

            if (id.charAt(0) == '3') {
                String regEx= "3[0-1]";
                if (day.matches(regEx)) {
                    pass = true;
                }
            }

            if (pass) {
                secondValidation = true;
            }

        }

        //  third validation = checking month's validity
        if (secondValidation) {
            // to pass the fourth validation,
            // first we have to check, if the first digit
            // is a number between 0 and 1, 
            //as months start with either
            boolean pass = false;
            String regEx1 = "0[1-9]";
            String regEx2 = "1[0-2]";
            String month = id.substring(2,4);

            if (month.matches(regEx1)) {
                pass = true;
            }

            if (month.matches(regEx2)) {
                pass = true;
            }

            if (pass) {
                thirdValidation = true;
            }
        }

        //fourth validation = checking leap year
        //and if the id contains 2902 in the beginning
        if (thirdValidation) {
            boolean pass = false;
            String dayAndMonth = id.substring(0,4);
            int year = Integer.parseInt(id.substring(4,6));

            if (dayAndMonth.equals("2902")) {
                if (year % 4 == 0) {
                    pass = true;
                }
            } else {
                pass = true;
            }

            //no need for century check with leap year
            //since it is safe to assume no one alive has been
            //born in the year 1900 (which cannot be 
            //divided with 400; 1900 % 4 != 0).

            if (pass) {
                fourthValidation = true;
            }
        }

        //fifth validation = checking the validity of the individual number
        if (fourthValidation) {
            boolean pass = false;
            int individualNumber = Integer.parseInt(id.substring(7,10));

            //individual number must be between 002-899
            if (individualNumber >= 002 && individualNumber < 900) {
                pass = true;
            }

            if (pass) {
                fifthValidation = true;
            }
        }

        //sixth validation = checking, if the century mark
        //('-' for 1900 century or 'A' for 2000 century)
        //is valid. Basically only the 2000 century's
        //validity is checked
        if (fifthValidation) {
            boolean pass = false;
            int year = Integer.parseInt(id.substring(4,6));

            LocalDate localDate = LocalDate.now();
            String currentYearStringified = String.valueOf(localDate.getYear());
            String substring = currentYearStringified.substring(2,4);
            int currentYear = Integer.parseInt(substring);

            if (year > currentYear) {
                if (id.charAt(6) == '-') {
                    pass = true;
                }
            } else {
                pass = true;
            }

            if (pass) {
                sixthValidation = true;
            }
        }

        //seventh and final validation = calculating the hash from
        //merging all the numbers together by dividing them
        //by 31 and determining the check digit based on
        //the remainder of the division (if remainder = 10,
        //the check digit will be A).
        if (sixthValidation) {
            char[] checkDigits = {'0','1','2','3','4','5','6','7','8','9','A',
            'B','C','D','E','F','H','J','K','L','M','N','P','R','S','T','U',
            'V','W','X','Y'};
            String date = id.substring(0,6);
            String individualNumber = id.substring(7,10);
            String substringsMerged = date + individualNumber;

            int numbersMerged = Integer.parseInt(substringsMerged);
            int remainder = numbersMerged % 31;
            char checkDigit = checkDigits[remainder];

            //this is the last check to see, if the ID
            //as a whole is valid
            if (checkDigit == id.charAt(10)) {
                valid = true;
            }
        }
        return valid;
    }

    /**
     * Used for validating first name
     * 
     * It is worth to note that there must be a capital letter first.
     * regEx1 variable is for the normal form of a name.
     * regEx2 variable contains model that takes into account,
     * if a dash character is used. In that case, the next
     * character after dash must be a capital letter.
     */
    public boolean validateFirstName(String firstName) {
        boolean valid = false;
        String regEx1 = "[A-ZÅÄÖ][a-zåäöA-ZÅÄÖ]+";
        String regEx2 = "[A-ZÅÄÖ][a-zåäö]+[-][A-ZÅÄÖ][a-zåäö]+";

        if (firstName.matches(regEx1)) {
            valid = true;
        }

        if (firstName.matches(regEx2)) {
            valid = true;
        }

        return valid;
    }

    /**
     * Used for validating last name
     * 
     * It is worth to note that there must be a capital letter first.
     * regEx1 variable is for the normal form of a name.
     * regEx2 variable contains model that takes into account,
     * if a dash character is used. In that case, the next
     * character after dash must be a capital letter.
     */
    public boolean validateLastName(String lastName) {
        boolean valid = false;
        String regEx1 = "[A-ZÅÄÖ][a-zåäöA-ZÅÄÖ]+";
        String regEx2 = "[A-ZÅÄÖ][a-zåäö]+[-][A-ZÅÄÖ][a-zåäö]+";

        if (lastName.matches(regEx1)) {
            valid = true;
        }

        if (lastName.matches(regEx2)) {
            valid = true;
        }

        return valid;
    }

    /**
     * Used for validating phone number.
     * 
     * There are two regular expression patterns that can be used, 
     * one for the mobile numbers, one for the old style phones.
     * The mobilephone has to have +358 followed by six or nine numbers.
     * The old style connection must have two digits beginning with 0
     * followed by 7 numbers.
     * 
     */
    public boolean validatePhoneNumber(String phoneNumber) {
        boolean valid = false;
        String regEx1 = "[+]358\\d{6,9}";
        String regEx2 = "0[1-9]\\d{7}";

        if (phoneNumber.matches(regEx1)) {
            valid = true;
            return valid;
        }

        if (phoneNumber.matches(regEx2)) {
            valid = true;
            return valid;
        }

        return valid;
    }

    /**
     * Used for validating address.
     * 
     * In the end there must be a number, a capital letter and another number.
     * The parameter can be null or empty.
     * 
     */
    public boolean validateAddress(String address) {
        boolean valid = false;
        String regEx = "[A-ZÅÄÖ][\\sa-zåäöA-ZÅÄÖ-]+ \\d{1,3} [A-Z] \\d{1,3}";

        if (address.matches(regEx) || address == null) {
            valid = true;
        }

        return valid;
    }

    /**
     * Used for validating email.
     * 
     * The parameter can be null or empty.
     * 
     */
    public boolean validateEmail(String email) {
        boolean valid = false;
        String regEx= "[0-9a-zåäöA-ZÅÄÖ._%+-]+@[0-9a-zåäöA-ZÅÄÖ.-]+.[a-z]{2,4}";

        if (email.matches(regEx) || email == null) {
            valid = true;
        }

        return valid;
    }


}