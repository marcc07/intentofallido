package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.Appointment;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
    Appointment save(Appointment appointment);
    Optional<Appointment> findById(long id);
    List<Appointment> findAll();
    List<Appointment> findByDate(LocalDateTime dateTime);
    void deleteById(long id);
}
