package Clinic.Clinic.domain.model;
import Clinic.Clinic.domain.model.ValOb.*;
public class ProcedureItem extends OrderItem {
    private final String procedureId;
    private final String procedureName;
    private final int times;
    private final String frequency;
    private final boolean requiresSpecialist;
    private final String specialtyId;
    
    public ProcedureItem(int itemNo, String procedureId, String procedureName, 
                        int times, String frequency, boolean requiresSpecialist, 
                        String specialtyId, Money cost) {
        super(itemNo, cost);
        this.procedureId = procedureId;
        this.procedureName = procedureName;
        this.times = times;
        this.frequency = frequency;
        this.requiresSpecialist = requiresSpecialist;
        this.specialtyId = specialtyId;
    }
    
    // Getters
    public String getProcedureId() { return procedureId; }
    public String getProcedureName() { return procedureName; }
    public int getTimes() { return times; }
    public String getFrequency() { return frequency; }
    public boolean isRequiresSpecialist() { return requiresSpecialist; }
    public String getSpecialtyId() { return specialtyId; }
    
    @Override
    public Money lineTotal() {
        return getCost().multiply(times);
    }
}