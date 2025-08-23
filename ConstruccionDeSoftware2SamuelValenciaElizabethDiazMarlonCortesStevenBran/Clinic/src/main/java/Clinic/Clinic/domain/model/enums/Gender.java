package Clinic.Clinic.domain.model.enums;

public enum Gender {
    MALE("Masculino"),
    FEMALE("Femenino"), 
    OTHER("Otro");
    
    private final String description;
    
    Gender(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}