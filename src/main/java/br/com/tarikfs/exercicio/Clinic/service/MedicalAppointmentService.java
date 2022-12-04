package br.com.tarikfs.exercicio.Clinic.service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarikfs.exercicio.Clinic.dto.medicalappointmentsdtos.MedicalAppointmentDto;
import br.com.tarikfs.exercicio.Clinic.dto.medicalappointmentsdtos.MedicalAppointmentRegistrationDto;
import br.com.tarikfs.exercicio.Clinic.mapper.MedicalAppointmentMapper;
import br.com.tarikfs.exercicio.Clinic.model.Doctor;
import br.com.tarikfs.exercicio.Clinic.model.MedicalAppointment;
import br.com.tarikfs.exercicio.Clinic.model.Patient;
import br.com.tarikfs.exercicio.Clinic.repository.DoctorRepository;
import br.com.tarikfs.exercicio.Clinic.repository.MedicalAppointmentRepository;
import br.com.tarikfs.exercicio.Clinic.repository.PatientRepository;

@Service
public class MedicalAppointmentService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    private MedicalAppointmentMapper medicalAppointmentMapper;

    @Transactional
    public MedicalAppointmentDto create(MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto) {
        Doctor doctorId = doctorRepository.findById(medicalAppointmentRegistrationDto.getDoctorUuid()).orElseThrow();
        Patient patientId = patientRepository.findById(medicalAppointmentRegistrationDto.getPatientUuid())
                .orElseThrow();
        MedicalAppointment medicalAppointment = medicalAppointmentMapper.toModel(medicalAppointmentRegistrationDto);
        medicalAppointment.setDoctor(doctorId);
        medicalAppointment.setPatient(patientId);
        medicalAppointmentRepository.save(medicalAppointment);

        return medicalAppointmentMapper.toDto(medicalAppointment);
    }

    public List<MedicalAppointmentDto> findAll() {
        List<MedicalAppointment> medicalAppointments = medicalAppointmentRepository.findAll();
        return medicalAppointmentMapper.toListDto(medicalAppointments);
    }

    public MedicalAppointmentDto findById(UUID id) {
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(id).get();
        return medicalAppointmentMapper.toDto(medicalAppointment);
    }

    @Transactional
    public MedicalAppointmentRegistrationDto update(UUID id,
            MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto) {
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(id).get();
        medicalAppointment = medicalAppointmentMapper.mapPutModel(medicalAppointmentRegistrationDto,
                medicalAppointment);
        medicalAppointmentRepository.save(medicalAppointment);
        return medicalAppointmentMapper.toDtoRegistration(medicalAppointment);
    }

    @Transactional
    public MedicalAppointmentRegistrationDto patch(UUID id,
            MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto) {
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(id).get();
        medicalAppointment = medicalAppointmentMapper.mapPatchModel(medicalAppointmentRegistrationDto,
                medicalAppointment);
        medicalAppointmentRepository.save(medicalAppointment);
        return medicalAppointmentMapper.toDtoRegistration(medicalAppointment);
    }

    @Transactional
    public void delete(UUID id) {
        medicalAppointmentRepository.deleteById(id);
    }

    public List<MedicalAppointmentDto> findByTimePeriod(Date startDate, Date endDate) {
        List<MedicalAppointment> findByDate = medicalAppointmentRepository.findByTimePeriod(startDate, endDate);
        return medicalAppointmentMapper.toListDto(findByDate);
    }
}
