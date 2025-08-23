package Clinic.Clinic.domain.model;

import Clinic.Clinic.domain.model.ValOb.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class MedicalNoteRepository {
    private final LocalDateTime visitDate;
    private final String doctorNationalId;
    private final String reason;
    private final String symptoms;
    private String diagnosis;
    private VitalSigns vitalSigns;
    private String observations;
    private final Set<String> relatedOrderNumbers;
    
    public MedicalNoteRepository(LocalDateTime visitDate, String doctorNationalId, 
                      String reason, String symptoms) {
        this.visitDate = visitDate;
        this.doctorNationalId = doctorNationalId;
        this.reason = reason;
        this.symptoms = symptoms;
        this.relatedOrderNumbers = new HashSet<>();
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public void addVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }
    
    public void addObservation(String observation) {
        this.observations = observation;
    }
    
    public void addRelatedOrder(String orderNumber) {
        this.relatedOrderNumbers.add(orderNumber);
    }
    
    // Getters
    public LocalDateTime getVisitDate() { return visitDate; }
    public String getDoctorNationalId() { return doctorNationalId; }
    public String getReason() { return reason; }
    public String getSymptoms() { return symptoms; }
    public String getDiagnosis() { return diagnosis; }
    public VitalSigns getVitalSigns() { return vitalSigns; }
    public String getObservations() { return observations; }
    public Set<String> getRelatedOrderNumbers() { return relatedOrderNumbers; }
}