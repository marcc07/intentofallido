package Clinic.Clinic.domain.model;

import Clinic.Clinic.domain.model.enums.RoleType;
import Clinic.Clinic.domain.model.ValOb.*;

public class User {
    private final String nationalId;
    private final FullName fullName;
    private Email email;
    private PhoneNumber phone;
    private final DateOfBirth dateOfBirth;
    private Adress adress;
    private RoleType role;
    private final String username;
    private String passwordHash;
    
    public User(String nationalId, FullName fullName, Email email, 
               PhoneNumber phone, DateOfBirth dateOfBirth, 
               Adress adress, RoleType role, String username) {
        
        this.nationalId = nationalId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.adress = adress;
        this.role = role;
        this.username = username;
    }
    
    public void validate() {
        if (username == null || username.length() > 15 || !username.matches("^[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("Nombre de usuario inválido");
        }
        
        if (passwordHash == null) {
            throw new IllegalArgumentException("Contraseña no establecida");
        }
    }
    
    public void changePassword(String newRawPassword) {
        if (!isValidPassword(newRawPassword)) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres, una mayúscula, un número y un carácter especial");
        }
        this.passwordHash = hashPassword(newRawPassword);
    }
    
    private boolean isValidPassword(String password) {
        return password != null && 
               password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*()].*");
    }
    
    private String hashPassword(String password) {
        
        return Integer.toString(password.hashCode());
    }
    
    public void changeContact(Email email, PhoneNumber phone, Adress adress) {
        this.email = email;
        this.phone = phone;
        this.adress = adress;
    }
    
    public void assignRole(RoleType role) {
        this.role = role;
    }
    
    // Getters
    public String getNationalId() { return nationalId; }
    public FullName getFullName() { return fullName; }
    public Email getEmail() { return email; }
    public PhoneNumber getPhone() { return phone; }
    public DateOfBirth getDateOfBirth() { return dateOfBirth; }
    public Adress getAdress() { return adress; }
    public RoleType getRole() { return role; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
}
