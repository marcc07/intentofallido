package Clinic.Clinic.domain.port;

import Clinic.Clinic.domain.model.*;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    Optional<User> findByNationalId(String nationalId);
    User save(User user);
    void deleteByNationalId(String nationalId);
    boolean existsUsername(String username);
    boolean existsNationalId(String nationalId);
}
