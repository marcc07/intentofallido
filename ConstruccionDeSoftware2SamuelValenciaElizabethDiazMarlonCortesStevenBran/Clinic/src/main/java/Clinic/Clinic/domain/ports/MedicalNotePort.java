package Clinic.Clinic.domain.ports;


import Clinic.Clinic.domain.model.MedicalNote;

public interface MedicalNotePort {
    MedicalNote findById(MedicalNote note) throws Exception;
    void save(MedicalNote note) throws Exception;
}
