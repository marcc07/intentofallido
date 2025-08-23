package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.*;
import Clinic.Clinic.domain.model.ValOb.Money;
import Clinic.Clinic.domain.port.OrderRepository;
import Clinic.Clinic.domain.port.PatientRepository;
import Clinic.Clinic.domain.port.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    
    public OrderService(OrderRepository orderRepository,
                       PatientRepository patientRepository,
                       UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }
    
    public Order createOrder(String orderNumber, String patientId, String doctorId) {
        
        patientRepository.findByNationalId(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
        
        userRepository.findByNationalId(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Médico no encontrado"));
        
        if (orderRepository.existsOrderNumber(orderNumber)) {
            throw new IllegalArgumentException("Número de orden ya existe");
        }
        
        Order order = new Order(orderNumber, patientId, doctorId);
        return orderRepository.save(order);
    }
    
    public Order addMedicationToOrder(String orderNumber, String medicineId,
                                    String medicineName, String dose,
                                    String duration, double cost) {
        
        Order order = getOrderByNumber(orderNumber);
        Money medicationCost = Money.of((long)(cost * 100), "COP");
        
        order.addMedicationItem(medicineId, medicineName, dose, duration, medicationCost);
        order.validateExclusiveAidRule();
        
        return orderRepository.save(order);
    }
    
    public Order addProcedureToOrder(String orderNumber, String procedureId,
                                   String procedureName, int times,
                                   String frequency, boolean requiresSpecialist,
                                   String specialtyId, double cost) {
        
        Order order = getOrderByNumber(orderNumber);
        Money procedureCost = Money.of((long)(cost * 100), "COP");
        
        order.addProcedureItem(procedureId, procedureName, times, frequency,
                             requiresSpecialist, specialtyId, procedureCost);
        order.validateExclusiveAidRule();
        
        return orderRepository.save(order);
    }
    
    public Order addDiagnosticAidToOrder(String orderNumber, String aidId,
                                       String aidName, int quantity,
                                       boolean requiresSpecialist,
                                       String specialtyId, double cost) {
        
        Order order = getOrderByNumber(orderNumber);
        Money aidCost = Money.of((long)(cost * 100), "COP");
        
        order.addDiagnosticAidItem(aidId, aidName, quantity, requiresSpecialist,
                                 specialtyId, aidCost);
        order.validateExclusiveAidRule();
        
        return orderRepository.save(order);
    }
    
    public Order getOrderByNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new IllegalArgumentException("Orden no encontrada"));
    }
    
    public void removeItemFromOrder(String orderNumber, int itemNumber) {
        Order order = getOrderByNumber(orderNumber);
        order.removeItem(itemNumber);
        orderRepository.save(order);
    }
    
    public boolean isAidOnlyOrder(String orderNumber) {
        Order order = getOrderByNumber(orderNumber);
        return order.isAidOnly();
    }
}