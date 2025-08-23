package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.User;
import Clinic.Clinic.domain.model.enums.RoleType;
import Clinic.Clinic.domain.model.ValOb.*;
import Clinic.Clinic.domain.port.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(String nationalId, String firstName, String lastName, 
                          String email, String phone, LocalDate birthDate,
                          String addressLine, RoleType role, String username, 
                          String password) {
        
       
        if (userRepository.existsNationalId(nationalId)) {
            throw new IllegalArgumentException("Usuario con cédula " + nationalId + " ya existe");
        }
        if (userRepository.existsUsername(username)) {
            throw new IllegalArgumentException("Nombre de usuario " + username + " ya existe");
        }
        
       
        FullName fullName = FullName.of(firstName, lastName);
        Email userEmail = Email.of(email);
        PhoneNumber phoneNumber = PhoneNumber.of(phone);
        DateOfBirth dateOfBirth = DateOfBirth.of(birthDate);
        Adress address = Adress.of(addressLine);
        
       
        User user = new User(nationalId, fullName, userEmail, phoneNumber, 
                           dateOfBirth, address, role, username);
        
        user.changePassword(password);
        user.validate();
        
        return userRepository.save(user);
    }
    
    public User updateUserContact(String nationalId, String email, String phone, String addressLine) {
        User user = getUserByNationalId(nationalId);
        
        Email newEmail = Email.of(email);
        PhoneNumber newPhone = PhoneNumber.of(phone);
        Adress newAddress = Adress.of(addressLine);
        
        user.changeContact(newEmail, newPhone, newAddress);
        return userRepository.save(user);
    }
    
    public User changeUserPassword(String nationalId, String newPassword) {
        User user = getUserByNationalId(nationalId);
        user.changePassword(newPassword);
        return userRepository.save(user);
    }
    
    public User changeUserRole(String nationalId, RoleType newRole) {
        User user = getUserByNationalId(nationalId);
        user.assignRole(newRole);
        return userRepository.save(user);
    }
    
    public User getUserByNationalId(String nationalId) {
        return userRepository.findByNationalId(nationalId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }
    
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }
    
    public void deleteUser(String nationalId) {
        if (!userRepository.existsNationalId(nationalId)) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        userRepository.deleteByNationalId(nationalId);
    }
    
    public boolean validateUserCredentials(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> user.getPasswordHash().equals(hashPassword(password)))
                .orElse(false);
    }
    
    public boolean usernameExists(String username) {
        return userRepository.existsUsername(username);
    }
    
    public boolean nationalIdExists(String nationalId) {
        return userRepository.existsNationalId(nationalId);
    }
    
    private String hashPassword(String password) {
        
        return Integer.toString(password.hashCode());
    }
}