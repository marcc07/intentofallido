package Clinic.Clinic.domain.model;

import Clinic.Clinic.domain.model.ValOb.*;

public class CopayLedger {
    private final String patientNationalId;
    private final int year;
    private Money accumulatedCopay;
    
    public CopayLedger(String patientNationalId, int year) {
        this.patientNationalId = patientNationalId;
        this.year = year;
        this.accumulatedCopay = Money.of(0, "COP");
    }
    
    public void addCopay(Money amount) {
        this.accumulatedCopay = this.accumulatedCopay.add(amount);
    }
    
    public boolean isCapReached() {
        return accumulatedCopay.getAmount() >= 1000000; 
    }
    
    // Getters
    public String getPatientNationalId() { return patientNationalId; }
    public int getYear() { return year; }
    public Money getAccumulatedCopay() { return accumulatedCopay; }
    }