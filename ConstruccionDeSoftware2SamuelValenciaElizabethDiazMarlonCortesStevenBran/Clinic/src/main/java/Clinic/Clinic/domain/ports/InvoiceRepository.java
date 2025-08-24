package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.Invoice;
import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {
    Invoice save(Invoice invoice);
    Optional<Invoice> findById(long id);
    List<Invoice> findAll();
    void deleteById(long id);
}
