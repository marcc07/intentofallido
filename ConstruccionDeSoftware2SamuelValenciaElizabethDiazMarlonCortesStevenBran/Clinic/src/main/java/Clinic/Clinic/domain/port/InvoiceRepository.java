package Clinic.Clinic.domain.port;

import Clinic.Clinic.domain.model.Invoice;
import java.util.Optional;

public interface InvoiceRepository {
    Optional<Invoice> findById(String id);
    Invoice save(Invoice invoice);
}