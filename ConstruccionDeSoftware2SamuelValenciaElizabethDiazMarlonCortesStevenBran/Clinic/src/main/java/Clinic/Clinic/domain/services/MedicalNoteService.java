package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.*;
import Clinic.Clinic.domain.model.ValOb.*;
import Clinic.Clinic.domain.port.*; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MedicalNoteService {
    
    private final MedicalRepo medicalRepo; 
    private final PatientRepository patientRepository;
    
    public MedicalNoteService(MedicalRepo medicalRepo,
                            PatientRepository patientRepository) {
        this.medicalRepo = medicalRepo;
        this.patientRepository = patientRepository;
    }
    
    public MedicalNoteRepository createMedicalNote(String patientId, String doctorId,
                                       String reason, String symptoms) {
        
        patientRepository.findByNationalId(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
        
        MedicalNoteRepository note = new MedicalNoteRepository(LocalDateTime.now(), doctorId, reason, symptoms);
        return medicalRepo.save(note); 
    }
    
    public MedicalNoteRepository recordVitalSigns(String patientId, LocalDateTime visitDate,
                                      String bloodPressure, double temperature,
                                      int pulse, int oxygenSaturation) {
        
        MedicalNoteRepository note = getMedicalNote(patientId, visitDate);
        VitalSigns vitalSigns = VitalSigns.of(bloodPressure, temperature, pulse, oxygenSaturation);
        
        note.addVitalSigns(vitalSigns);
        return medicalRepo.save(note);
    }
    
    public MedicalNoteRepository addDiagnosis(String patientId, LocalDateTime visitDate, String diagnosis) {
        MedicalNoteRepository note = getMedicalNote(patientId, visitDate);
        note.setDiagnosis(diagnosis);
        return medicalRepo.save(note);
    }
    
    public MedicalNoteRepository addObservations(String patientId, LocalDateTime visitDate, String observations) {
        MedicalNoteRepository note = getMedicalNote(patientId, visitDate);
        note.addObservation(observations);
        return medicalRepo.save(note);
    }
    
    public MedicalNoteRepository linkOrderToNote(String patientId, LocalDateTime visitDate, String orderNumber) {
        MedicalNoteRepository note = getMedicalNote(patientId, visitDate);
        note.addRelatedOrder(orderNumber);
        return medicalRepo.save(note);
    }
    
    public List<MedicalNoteRepository> getPatientMedicalHistory(String patientId) {
        return medicalRepo.findAllByPatient(patientId);
    }
    
    public MedicalNoteRepository getMedicalNote(String patientId, LocalDateTime visitDate) {
        return medicalRepo.findByPatientAndDate(patientId, visitDate)
                .orElseThrow(() -> new IllegalArgumentException("Nota médica no encontrada"));
    }
}
