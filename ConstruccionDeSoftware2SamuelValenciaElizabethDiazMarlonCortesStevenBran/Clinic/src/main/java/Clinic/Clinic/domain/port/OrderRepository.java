package Clinic.Clinic.domain.port;


import Clinic.Clinic.domain.model.*;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findByOrderNumber(String orderNumber);
    Order save(Order order);
    boolean existsOrderNumber(String orderNumber);
}