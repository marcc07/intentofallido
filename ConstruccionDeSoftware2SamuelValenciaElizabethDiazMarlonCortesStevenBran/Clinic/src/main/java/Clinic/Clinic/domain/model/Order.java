package Clinic.Clinic.domain.model;

import Clinic.Clinic.domain.model.ValOb.Money;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String orderNumber;
    private final String patientNationalId;
    private final String doctorNationalId;
    private final LocalDateTime createdAt;
    private final List<OrderItem> items;
    
    public Order(String orderNumber, String patientNationalId, String doctorNationalId) {
        this.orderNumber = orderNumber;
        this.patientNationalId = patientNationalId;
        this.doctorNationalId = doctorNationalId;
        this.createdAt = LocalDateTime.now();
        this.items = new ArrayList<>();
    }
    
    public void addMedicationItem(String medicineId, String medicineName, String dose, 
                                 String duration, Money cost) {
        MedicationItem item = new MedicationItem(nextItemNo(), medicineId, medicineName, 
                                                dose, duration, cost);
        items.add(item);
    }
    
    public void addProcedureItem(String procedureId, String procedureName, int times, 
                                String frequency, boolean requiresSpecialist, 
                                String specialtyId, Money cost) {
        ProcedureItem item = new ProcedureItem(nextItemNo(), procedureId, procedureName, 
                                              times, frequency, requiresSpecialist, 
                                              specialtyId, cost);
        items.add(item);
    }
    
    public void addDiagnosticAidItem(String aidId, String aidName, int quantity, 
                                    boolean requiresSpecialist, String specialtyId, 
                                    Money cost) {
        DiagnosticAidItem item = new DiagnosticAidItem(nextItemNo(), aidId, aidName, 
                                                      quantity, requiresSpecialist, 
                                                      specialtyId, cost);
        items.add(item);
    }
    
    public void removeItem(int itemNo) {
        items.removeIf(item -> item.getItemNo() == itemNo);
    }
    
    public boolean isAidOnly() {
        return items.stream().allMatch(item -> item instanceof DiagnosticAidItem);
    }
    
    public int nextItemNo() {
        return items.size() + 1;
    }
    
    public void validateExclusiveAidRule() {
        if (isAidOnly() && items.size() > 1) {
            throw new IllegalStateException("Las ayudas diagnósticas no pueden mezclarse con otros items");
        }
    }
    
    public boolean hasDuplicateItemNo() {
        return items.stream()
                   .map(OrderItem::getItemNo)
                   .distinct()
                   .count() != items.size();
    }
    
    // Getters
    public String getOrderNumber() { return orderNumber; }
    public String getPatientNationalId() { return patientNationalId; }
    public String getDoctorNationalId() { return doctorNationalId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<OrderItem> getItems() { return items; }
}