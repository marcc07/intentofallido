package Clinic.Clinic.domain.model;

import Clinic.Clinic.domain.model.ValOb.*;

public class MedicationItem extends OrderItem {
    private final String medicineId;
    private final String medicineName;
    private final String dose;
    private final String duration;
    
    public MedicationItem(int itemNo, String medicineId, String medicineName, 
                         String dose, String duration, Money cost) {
        super(itemNo, cost);
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.dose = dose;
        this.duration = duration;
    }
    
    public String getMedicineId() { return medicineId; }
    public String getMedicineName() { return medicineName; }
    public String getDose() { return dose; }
    public String getDuration() { return duration; }
}