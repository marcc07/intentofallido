package Clinic.Clinic.domain.model;


import java.time.LocalDate;
import java.util.List;

public class BillingCalculator {
    
    public Invoice computeInvoice(Patient patient, List<Order> orders, 
                                LocalDate today, CopayLedger ledger) {
        
        Invoice invoice = new Invoice(
            "INV-" + System.currentTimeMillis(),
            patient.getNationalId(),
            "Dr. Ejemplo",
            patient.getFullName().full(),
            patient.age(today),
            patient.getNationalId()
        );
        
      
        
        invoice.totalize();
        return invoice;
    }
}