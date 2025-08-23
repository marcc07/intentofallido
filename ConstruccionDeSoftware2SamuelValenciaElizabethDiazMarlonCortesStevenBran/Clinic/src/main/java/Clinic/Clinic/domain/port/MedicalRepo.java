package Clinic.Clinic.domain.port;

import Clinic.Clinic.domain.model.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MedicalRepo {
    Optional<MedicalNoteRepository> findByPatientAndDate(String patientId, LocalDateTime date);
    List<MedicalNoteRepository> findAllByPatient(String patientId);
    MedicalNoteRepository save(MedicalNoteRepository note);
}