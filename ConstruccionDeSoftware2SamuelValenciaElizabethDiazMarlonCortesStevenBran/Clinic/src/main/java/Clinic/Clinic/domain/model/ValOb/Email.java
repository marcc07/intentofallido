package Clinic.Clinic.domain.model.ValOb;

import java.util.regex.Pattern;

public class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    
    private final String value;
    
    private Email(String value) {
        this.value = value;
    }
    
    public static Email of(String value) {
        if (value == null || !isValid(value)) {
            throw new IllegalArgumentException("Email inválido");
        }
        return new Email(value.toLowerCase());
    }
    
    public static boolean isValid(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    
    public String domain() {
        return value.substring(value.indexOf('@') + 1);
    }
    
    public String getValue() { return value; }
}