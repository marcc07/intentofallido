package Clinic.Clinic.domain.model.ValOb;

public class EmergencyContact {
    private final String firstName;
    private final String lastName;
    private final String relation;
    private final PhoneNumber phone;
    
    private EmergencyContact(String firstName, String lastName, String relation, PhoneNumber phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.relation = relation;
        this.phone = phone;
    }
    
    public static EmergencyContact of(String firstName, String lastName, String relation, PhoneNumber phone) {
        if (firstName == null || lastName == null || relation == null || phone == null) {
            throw new IllegalArgumentException("Todos los campos del contacto de emergencia son requeridos");
        }
        return new EmergencyContact(firstName.trim(), lastName.trim(), relation.trim(), phone);
    }
    
    public String full() {
        return firstName + " " + lastName;
    }
    
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getRelation() { return relation; }
    public PhoneNumber getPhone() { return phone; }
}