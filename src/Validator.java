public class Validator {

    public boolean validateId(String id) {
        boolean valid = false;
        String regEx = "\\d{6}[-A]\\d{3}[0-9A-FHJ-OPR-Y]";

        if (id.matches(regEx)) {
            valid = true;
        }

        return valid;
    }

    public boolean validateFirstName(String firstName) {
        boolean valid = false;
        String regEx = "[a-zåäöA-ZÅÄÖ]+";

        if (firstName.matches(regEx)) {
            valid = true;
        }

        return valid;
    }

    public boolean validateLastName(String lastName) {
        boolean valid = false;
        String regEx = "[a-zåäöA-ZÅÄÖ-]+";

        if (lastName.matches(regEx)) {
            valid = true;
        }

        return valid;
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        boolean valid = false;
        String regEx = "[+]358\\d{6,9}";

        if (phoneNumber.matches(regEx)) {
            valid = true;
        }

        return valid;
    }

    public boolean validateAddress(String address) {
        boolean valid = false;
        String regEx = "[A-ZÅÄÖ][a-zåäö]+ \\d{1,3} [A-Z] \\d{1,3}";

        if (address.matches(regEx) || address == null) {
            valid = true;
        }

        return valid;
    }

    public boolean validateEmail(String email) {
        boolean valid = false;
        String regEx = "[0-9a-zåäöA-ZÅÄÖ._%+-]+@[0-9a-zåäöA-ZÅÄÖ.-]+.[a-z]{2,4}";

        if (email.matches(regEx) || email == null) {
            valid = true;
        }

        return valid;
    }


}