package br.com.tarikfs.exercicio.Clinic.service;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarikfs.exercicio.Clinic.dto.patientsDtos.PatientDto;
import br.com.tarikfs.exercicio.Clinic.dto.patientsDtos.PatientRegistrationDto;
import br.com.tarikfs.exercicio.Clinic.mapper.PatientMapper;
import br.com.tarikfs.exercicio.Clinic.model.Patient;
import br.com.tarikfs.exercicio.Clinic.repository.PatientRepository;
import br.com.tarikfs.exercicio.Clinic.util.GeneratePdfPatient;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Transactional
    public PatientDto postPatient(PatientRegistrationDto patientRegistrationDto) {
        Patient patientModel = patientMapper.toModelRegistration(patientRegistrationDto);
        patientRepository.save(patientModel);
        return patientMapper.toDto(patientModel);
    }

    public List<PatientDto> getAllPatients(String cpf) {
        return patientMapper.toListDto(patientRepository.findAll());
    }

    public PatientDto getPatientByCpf(String cpf) {
        Patient patient = patientRepository.findByCpf(cpf).orElseThrow();
        return patientMapper.toDto(patient);
    }

    @Transactional
    public PatientRegistrationDto updatePatient(String cpf, PatientRegistrationDto patientRegistrationDto) {
        Optional<Patient> patient = patientRepository.findByCpf(cpf);
        Patient patientModel = patient.orElseThrow(() -> new RuntimeException("Pacient not found"));
        patientModel = patientMapper.mapPutModel(patientRegistrationDto, patientModel);
        patientRepository.save(patientModel);
        return patientMapper.toDtoRegistration(patientModel);
    }

    @Transactional
    public PatientRegistrationDto patchPatient(String cpf, PatientRegistrationDto patientRegistrationDto) {
        Optional<Patient> patient = patientRepository.findByCpf(cpf);
        Patient patientModel = patient.orElseThrow(() -> new RuntimeException("patient not Found"));
        patientModel = patientMapper.patchPatient(patientRegistrationDto, patientModel);
        patientRepository.save(patientModel);
        return patientMapper.toDtoRegistration(patientModel);
    }

    @Transactional
    public PatientDto deletePatient(String cpf) {
        Patient patient = patientRepository.findByCpf(cpf).get();
        patientRepository.delete(patient);
        return patientMapper.toDto(patient);
    }

    public ResponseEntity<InputStreamResource> generatePdfPatient() {
        List<Patient> patients = patientRepository.findAll();

        ByteArrayInputStream bis = GeneratePdfPatient.patientReport(patients);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=patients.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
