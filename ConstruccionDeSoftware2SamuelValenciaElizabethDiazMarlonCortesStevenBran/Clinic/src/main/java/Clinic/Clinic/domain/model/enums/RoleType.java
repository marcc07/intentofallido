package Clinic.Clinic.domain.model.enums;

public enum RoleType {
    HR("Recursos Humanos"),
    DOCTOR("Médico"),
    NURSE("Enfermera"),
    ADMIN("Personal Administrativo"),
    SUPPORT("Soporte de Información");
    
    private final String description;
    
    RoleType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}