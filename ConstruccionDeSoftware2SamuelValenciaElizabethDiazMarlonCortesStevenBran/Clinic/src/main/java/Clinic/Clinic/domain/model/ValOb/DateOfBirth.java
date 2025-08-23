package Clinic.Clinic.domain.model.ValOb;

import java.time.LocalDate;
import java.time.Period;

public class DateOfBirth {
    private final LocalDate date;
    
    private DateOfBirth(LocalDate date) {
        this.date = date;
    }
    
    public static DateOfBirth of(LocalDate date) {
        if (date == null || !isValidMax150Years(date)) {
            throw new IllegalArgumentException("Fecha de nacimiento inválida");
        }
        return new DateOfBirth(date);
    }
    
    public static boolean isValidMax150Years(LocalDate birthDate) {
        return birthDate != null && 
               Period.between(birthDate, LocalDate.now()).getYears() <= 150;
    }
    
    public int age(LocalDate today) {
        return Period.between(date, today).getYears();
    }
    
    public LocalDate getDate() { return date; }
}