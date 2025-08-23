package Clinic.Clinic.domain.model;

import Clinic.Clinic.domain.model.enums.Gender;
import Clinic.Clinic.domain.model.ValOb.*;
import java.time.LocalDate;

public class Patient {
    private final String nationalId;
    private final FullName fullName;
    private final DateOfBirth dateOfBirth;
    private final Gender gender;
    private Adress address;
    private PhoneNumber phone;
    private Email email;
    private EmergencyContact emergencyContact;
    private Policy policy;
    
    public Patient(String nationalId, FullName fullName, DateOfBirth dateOfBirth, 
                  Gender gender, Adress address, PhoneNumber phone, Email email) {
        
        this.nationalId = nationalId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    
    public int age(LocalDate today) {
        return dateOfBirth.age(today);
    }
    
    public boolean hasActivePolicy(LocalDate today) {
        return policy != null && policy.isActive(today);
    }
    
    public void setEmergencyContact(EmergencyContact contact) {
        this.emergencyContact = contact;
    }
    
    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
    
    public void clearPolicy() {
        this.policy = null;
    }
    
    public void validateForAdminRules(LocalDate today) {
        if (emergencyContact == null) {
            throw new IllegalStateException("Contacto de emergencia requerido");
        }
    }
    
    // Getters
    public String getNationalId() { return nationalId; }
    public FullName getFullName() { return fullName; }
    public DateOfBirth getDateOfBirth() { return dateOfBirth; }
    public Gender getGender() { return gender; }
    public Adress getAddress() { return address; }
    public PhoneNumber getPhone() { return phone; }
    public Email getEmail() { return email; }
    public EmergencyContact getEmergencyContact() { return emergencyContact; }
    public Policy getPolicy() { return policy; }
}