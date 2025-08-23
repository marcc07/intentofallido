package Clinic.Clinic.domain.port;

import Clinic.Clinic.domain.model.CopayLedger;
import java.util.Optional;

public interface LedgerRepository {
    Optional<CopayLedger> findByPatientAndYear(String patientId, int year);
    CopayLedger save(CopayLedger ledger);
}