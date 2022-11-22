package br.com.tarikfs.exercicio.consultorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarikfs.exercicio.consultorio.dto.patientsDtos.PatientDto;
import br.com.tarikfs.exercicio.consultorio.dto.patientsDtos.PatientRegistrationDto;
import br.com.tarikfs.exercicio.consultorio.mapper.PatientMapper;
import br.com.tarikfs.exercicio.consultorio.model.Patient;
import br.com.tarikfs.exercicio.consultorio.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientMapper patientMapper;

    @Transactional
    public PatientDto postPatient(PatientRegistrationDto patientRegistrationDto) {
        Patient patientModel = patientMapper.toModelRegistration(patientRegistrationDto);
        patientRepository.save(patientModel);
        return patientMapper.toDto(patientModel);
    }

    public List<PatientDto> getAllPatients(String cpf) {
        return patientMapper.toListDto(patientRepository.findAll());
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
}
