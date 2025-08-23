package Clinic.Clinic.domain.model.ValOb;

import java.time.LocalDate;
import java.time.Period;

public class Policy {
    private final String companyName;
    private final String policyNumber;
    private final boolean active;
    private final LocalDate endDate;
    
    private Policy(String companyName, String policyNumber, boolean active, LocalDate endDate) {
        this.companyName = companyName;
        this.policyNumber = policyNumber;
        this.active = active;
        this.endDate = endDate;
    }
    
    public static Policy of(String companyName, String policyNumber, boolean active, LocalDate endDate) {
        if (companyName == null || policyNumber == null || endDate == null) {
            throw new IllegalArgumentException("Todos los campos de la póliza son requeridos");
        }
        return new Policy(companyName.trim(), policyNumber.trim(), active, endDate);
    }
    
    public boolean isExpired(LocalDate today) {
        return today.isAfter(endDate);
    }
    
    public boolean isActive(LocalDate today) {
        return active && !isExpired(today);
    }
    
    public int daysToEnd(LocalDate today) {
        return Period.between(today, endDate).getDays();
    }
    
    public String getCompanyName() { return companyName; }
    public String getPolicyNumber() { return policyNumber; }
    public boolean isActive() { return active; }
    public LocalDate getEndDate() { return endDate; }
}