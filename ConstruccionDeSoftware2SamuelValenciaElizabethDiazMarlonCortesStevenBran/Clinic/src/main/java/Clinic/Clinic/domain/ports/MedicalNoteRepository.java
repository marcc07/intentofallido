package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.MedicalNote;
import java.util.List;
import java.util.Optional;

public interface MedicalNoteRepository {
    MedicalNote save(MedicalNote note);
    Optional<MedicalNote> findById(long id);
    List<MedicalNote> findAll();
    void deleteById(long id);
}
