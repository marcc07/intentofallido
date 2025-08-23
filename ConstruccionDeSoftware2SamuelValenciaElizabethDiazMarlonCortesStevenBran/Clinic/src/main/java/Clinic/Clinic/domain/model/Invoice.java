package Clinic.Clinic.domain.model;

import Clinic.Clinic.domain.model.ValOb.Money;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private final String id;
    private final String patientNationalId;
    private String doctorName;
    private final String patientName;
    private final int patientAge;
    private final String patientIdNumber;
    private String companyName;
    private String policyNumber;
    private Integer policyDaysLeft;
    private LocalDate policyEndDate;
    private final List<InvoiceLine> lines;
    private Money patientPay;
    private Money insurerPay;
    private Money total;
    
    public Invoice(String id, String patientNationalId, String doctorName,
                  String patientName, int patientAge, String patientIdNumber) {
        this.id = id;
        this.patientNationalId = patientNationalId;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientIdNumber = patientIdNumber;
        this.lines = new ArrayList<>();
        this.patientPay = Money.of(0, "COP");
        this.insurerPay = Money.of(0, "COP");
        this.total = Money.of(0, "COP");
    }
    
    // 🔽🔽🔽 AGREGA ESTOS SETTERS 🔽🔽🔽
    
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    
    public void setPolicyDaysLeft(Integer policyDaysLeft) {
        this.policyDaysLeft = policyDaysLeft;
    }
    
    public void setPolicyEndDate(LocalDate policyEndDate) {
        this.policyEndDate = policyEndDate;
    }
    
    public void setPatientPay(Money patientPay) {
        this.patientPay = patientPay;
    }
    
    public void setInsurerPay(Money insurerPay) {
        this.insurerPay = insurerPay;
    }
    
    public void setTotal(Money total) {
        this.total = total;
    }
    
    public void addLine(InvoiceLine line) {
        lines.add(line);
    }
    

    

    public String getId() { return id; }
    public String getPatientNationalId() { return patientNationalId; }
    public String getDoctorName() { return doctorName; }
    public String getPatientName() { return patientName; }
    public int getPatientAge() { return patientAge; }
    public String getPatientIdNumber() { return patientIdNumber; }
    public String getCompanyName() { return companyName; }
    public String getPolicyNumber() { return policyNumber; }
    public Integer getPolicyDaysLeft() { return policyDaysLeft; }
    public LocalDate getPolicyEndDate() { return policyEndDate; }
    public List<InvoiceLine> getLines() { return lines; }
    public Money getPatientPay() { return patientPay; }
    public Money getInsurerPay() { return insurerPay; }
    public Money getTotal() { return total; }
}
