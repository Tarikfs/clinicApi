package br.com.tarikfs.exercicio.consultorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarikfs.exercicio.consultorio.dto.MedicalAppointmentsDtos.MedicalAppointmentDto;
import br.com.tarikfs.exercicio.consultorio.dto.MedicalAppointmentsDtos.MedicalAppointmentRegistrationDto;
import br.com.tarikfs.exercicio.consultorio.mapper.MedicalAppointmentMapper;
import br.com.tarikfs.exercicio.consultorio.model.MedicalAppointment;
import br.com.tarikfs.exercicio.consultorio.repository.MedicalAppointmentRepository;

@Service
public class MedicalAppointmentService {

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    private MedicalAppointmentMapper medicalAppointmentMapper;

    @Transactional
    public MedicalAppointmentDto create(MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto) {
        MedicalAppointment medicalAppointment = medicalAppointmentMapper.toModel(medicalAppointmentRegistrationDto);
        medicalAppointmentRepository.save(medicalAppointment);
        return medicalAppointmentMapper.toDto(medicalAppointment);
    }

    public List<MedicalAppointmentDto> findAll() {
        List<MedicalAppointment> medicalAppointments = medicalAppointmentRepository.findAll();
        return medicalAppointmentMapper.toListDto(medicalAppointments);
    }

    public MedicalAppointmentDto findById(Long id) {
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(id).get();
        return medicalAppointmentMapper.toDto(medicalAppointment);
    }

    @Transactional
    public MedicalAppointmentRegistrationDto update(Long id,
            MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto) {
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(id).get();
        medicalAppointment = medicalAppointmentMapper.mapPutModel(medicalAppointmentRegistrationDto,
                medicalAppointment);
        medicalAppointmentRepository.save(medicalAppointment);
        return medicalAppointmentMapper.toDtoRegistration(medicalAppointment);
    }

    @Transactional
    public MedicalAppointmentRegistrationDto patch(Long id,
            MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto) {
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(id).get();
        medicalAppointment = medicalAppointmentMapper.mapPatchModel(medicalAppointmentRegistrationDto,
                medicalAppointment);
        medicalAppointmentRepository.save(medicalAppointment);
        return medicalAppointmentMapper.toDtoRegistration(medicalAppointment);
    }

    @Transactional
    public void delete(Long id) {
        medicalAppointmentRepository.deleteById(id);
    }
}