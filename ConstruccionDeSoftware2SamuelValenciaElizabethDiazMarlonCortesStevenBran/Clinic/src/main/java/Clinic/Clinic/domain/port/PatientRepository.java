package Clinic.Clinic.domain.port;

import Clinic.Clinic.domain.model.*;
import java.util.Optional;

public interface PatientRepository {
    Optional<Patient> findByNationalId(String nationalId);
    Patient save(Patient patient);
    void deleteByNationalId(String nationalId);
    boolean existsNationalId(String nationalId);
}