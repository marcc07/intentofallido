package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(long id);
    List<User> findAll();
    void deleteById(long id);
}
