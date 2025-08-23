package Clinic.Clinic.domain.model;

import Clinic.Clinic.domain.model.ValOb.*;

public class DiagnosticAidItem extends OrderItem {
    private final String aidId;
    private final String aidName;
    private final int quantity;
    private final boolean requiresSpecialist;
    private final String specialtyId;
    
    public DiagnosticAidItem(int itemNo, String aidId, String aidName, 
                            int quantity, boolean requiresSpecialist, 
                            String specialtyId, Money cost) {
        super(itemNo, cost);
        this.aidId = aidId;
        this.aidName = aidName;
        this.quantity = quantity;
        this.requiresSpecialist = requiresSpecialist;
        this.specialtyId = specialtyId;
    }
    
    // Getters
    public String getAidId() { return aidId; }
    public String getAidName() { return aidName; }
    public int getQuantity() { return quantity; }
    public boolean isRequiresSpecialist() { return requiresSpecialist; }
    public String getSpecialtyId() { return specialtyId; }
    

    public Money lineTotal() {
        return getCost().multiply(quantity);
    }
}