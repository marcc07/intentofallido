package Clinic.Clinic.domain.model.ValOb;


public class FullName {
    private final String firstName;
    private final String lastName;
    
    private FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public static FullName of(String firstName, String lastName) {
        if (firstName == null || lastName == null || 
            firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre y apellido son requeridos");
        }
        return new FullName(firstName.trim(), lastName.trim());
    }
    
    public String full() {
        return firstName + " " + lastName;
    }
    
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}