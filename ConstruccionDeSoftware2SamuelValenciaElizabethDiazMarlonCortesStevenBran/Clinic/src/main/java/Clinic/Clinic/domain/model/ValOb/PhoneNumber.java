package Clinic.Clinic.domain.model.ValOb;
import java.util.regex.Pattern;



public class PhoneNumber {
    private static final Pattern DIGITS_ONLY = Pattern.compile("^\\d+$");
    
    private final String digits;
    
    private PhoneNumber(String digits) {
        this.digits = digits;
    }
    
    public static PhoneNumber of(String digits) {
        if (digits == null || !isNumeric(digits) || !isTenDigits(digits)) {
            throw new IllegalArgumentException("Número de teléfono inválido");
        }
        return new PhoneNumber(digits);
    }
    
    public static boolean isNumeric(String phone) {
        return phone != null && DIGITS_ONLY.matcher(phone).matches();
    }
    
    public static boolean isTenDigits(String phone) {
        return phone != null && phone.length() == 10;
    }
    
    public String getDigits() { return digits; }
}