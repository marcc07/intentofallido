package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.*;
import Clinic.Clinic.domain.model.ValOb.*;
import Clinic.Clinic.domain.port.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class PatientService {
    
    private final PatientRepository patientRepository;
    
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    
    public Patient createPatient(String nationalId, String firstName, String lastName,
                               java.time.LocalDate birthDate, String gender,
                               String address, String phone, String email) {
        
        if (patientRepository.existsNationalId(nationalId)) {
            throw new IllegalArgumentException("Paciente con cédula " + nationalId + " ya existe");
        }
      
        FullName fullName = FullName.of(firstName, lastName);
        DateOfBirth dateOfBirth = DateOfBirth.of(birthDate);
        Adress patientAddress = Adress.of(address);
        PhoneNumber phoneNumber = PhoneNumber.of(phone);
        Email patientEmail = Email.of(email);
        
     
        Clinic.Clinic.domain.model.enums.Gender genderEnum = Clinic.Clinic.domain.model.enums.Gender.valueOf(gender.toUpperCase());
        
        Patient patient = new Patient(nationalId, fullName, dateOfBirth, genderEnum,
                                    patientAddress, phoneNumber, patientEmail);
        
        return patientRepository.save(patient);
    }
    
    public Patient getPatientById(String nationalId) {
        return patientRepository.findByNationalId(nationalId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
    }
    
    public Patient updateEmergencyContact(String patientId, String contactFirstName,
                                        String contactLastName, String relation,
                                        String contactPhone) {
        
        Patient patient = getPatientById(patientId);
        PhoneNumber phone = PhoneNumber.of(contactPhone);
        EmergencyContact emergencyContact = EmergencyContact.of(
            contactFirstName, contactLastName, relation, phone
        );
        
        patient.setEmergencyContact(emergencyContact);
        return patientRepository.save(patient);
    }
    
    public Patient updateInsurancePolicy(String patientId, String companyName,
                                       String policyNumber, boolean isActive,
                                       java.time.LocalDate endDate) {
        
        Patient patient = getPatientById(patientId);
        Policy policy = Policy.of(companyName, policyNumber, isActive, endDate);
        
        patient.setPolicy(policy);
        return patientRepository.save(patient);
    }
    
    public void removeInsurancePolicy(String patientId) {
        Patient patient = getPatientById(patientId);
        patient.clearPolicy();
        patientRepository.save(patient);
    }
    
    public boolean hasActiveInsurance(String patientId) {
        Patient patient = getPatientById(patientId);
        return patient.hasActivePolicy(LocalDate.now());
    }
    
    public void deletePatient(String nationalId) {
        if (!patientRepository.existsNationalId(nationalId)) {
            throw new IllegalArgumentException("Paciente no encontrado");
        }
        patientRepository.deleteByNationalId(nationalId);
    }
}