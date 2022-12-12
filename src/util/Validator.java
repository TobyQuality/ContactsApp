package util;
/**
 * Validation class is used in the Contact class's set methods.
 * 
 * The main function of the class is to call methods
 * for different validations (id, address etc.).
 * The validations are done by utilizing regular expressions.
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
     * 
     * @param id
     * @return boolean value contained in variable "valid".
     */
    public boolean validateId(String id) {
        boolean valid = false;
        String regEx = "\\d{6}[-A]\\d{3}[0-9A-FHJ-OPR-Y]";

        if (id.matches(regEx)) {
            valid = true;
        }

        return valid;
    }

    /**
     * Used for validating first name
     * 
     * @param id
     * @return boolean value contained in variable "valid".
     */
    public boolean validateFirstName(String firstName) {
        boolean valid = false;
        String regEx = "[a-zåäöA-ZÅÄÖ-]+";

        if (firstName.matches(regEx)) {
            valid = true;
        }

        return valid;
    }

    /**
     * Used for validating last name
     * 
     * @param id
     * @return boolean value contained in variable "valid".
     */
    public boolean validateLastName(String lastName) {
        boolean valid = false;
        String regEx = "[a-zåäöA-ZÅÄÖ-]+";

        if (lastName.matches(regEx)) {
            valid = true;
        }

        return valid;
    }

    /**
     * Used for validating phone number.
     * 
     * There are two regular expression patterns that can be used, 
     * one for the mobile numbers, one for the old style phones.
     * The mobilephone has to have +358 followed by nine numbers.
     * The old style connection must have two digits beginning with 0
     * followed by 7 numbers.
     * 
     * @param id
     * @return boolean value contained in variable "valid".
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
     * @param id
     * @return boolean value contained in variable "valid".
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
     * @param id
     * @return boolean value contained in variable "valid".
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