package br.com.tarikfs.exercicio.Clinic.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarikfs.exercicio.Clinic.dto.doctorsDtos.DoctorDto;
import br.com.tarikfs.exercicio.Clinic.dto.doctorsDtos.DoctorRegistrationDto;
import br.com.tarikfs.exercicio.Clinic.mapper.DoctorMapper;
import br.com.tarikfs.exercicio.Clinic.model.Doctor;
import br.com.tarikfs.exercicio.Clinic.repository.DoctorRepository;
import br.com.tarikfs.exercicio.Clinic.repository.MedicalAppointmentRepository;
import br.com.tarikfs.exercicio.Clinic.repository.PatientRepository;

@Service
public class DoctorService {
  @Autowired
  DoctorRepository doctorRepository;

  @Autowired
  PatientRepository patientRepository;

  @Autowired
  MedicalAppointmentRepository medicalAppointmentRepository;

  @Autowired
  private DoctorMapper doctorMapper;

  @Transactional
  public DoctorDto postDoctor(DoctorRegistrationDto doctorRegistrationDto) {
    Doctor doctorModel = doctorMapper.toModelRegistration(
        doctorRegistrationDto);
    doctorRepository.save(doctorModel);
    return doctorMapper.toDto(doctorModel);
  }

  public DoctorDto findByCrm(String crm) {
    Doctor doctor = doctorRepository.findByCrm(crm).get();
    return doctorMapper.toDto(doctor);
  }

  public List<DoctorDto> getsAllDoctors(String crm) {
    List<Doctor> doctors = doctorRepository.findAll();
    return doctorMapper.toListDto(doctors);
  }

  @Transactional
  public DoctorRegistrationDto updateDoctor(
      String crm,
      DoctorRegistrationDto doctorRegistrationDto) {
    Optional<Doctor> doctor = doctorRepository.findByCrm(crm);
    Doctor doctorModel = doctor.orElseThrow(
        () -> new RuntimeException("doctor not Found"));
    doctorModel = doctorMapper.mapPutModel(doctorRegistrationDto, doctorModel);
    doctorRepository.save(doctorModel);
    return doctorMapper.toDtoRegistration(doctorModel);
  }

  @Transactional
  public DoctorRegistrationDto patchDoctor(
      String crm,
      DoctorRegistrationDto doctorRegistrationDto) {
    Optional<Doctor> doctor = doctorRepository.findByCrm(crm);
    Doctor doctorModel = doctor.orElseThrow(
        () -> new RuntimeException("doctor not Found"));
    doctorModel = doctorMapper.patchDoctor(doctorRegistrationDto, doctorModel);
    doctorRepository.save(doctorModel);
    return doctorMapper.toDtoRegistration(doctorModel);
  }

  @Transactional
  public DoctorDto deleteDoctor(String crm) {
    Doctor doctor = doctorRepository.findByCrm(crm).get();
    doctorRepository.delete(doctor);
    return doctorMapper.toDto(doctor);
  }

  // public List<DoctorDto> findPatientByDoctor(UUID doctorId) {
  //   Optional<Patient> patient = patientRepository.findById(doctorId);
  //   List<Doctor> doctorByPatient = doctorRepository.doctorByPatient(findByCrm(patient.get().getCpf()));
  //   return doctorByPatient.stream().map(x -> new DoctorDto()).collect(Collectors.toList());
  // }

  public List<DoctorDto> findByTimePeriod(Date startDate, Date endDate) {
  List<Doctor> findByDate = doctorRepository.findByTimePeriod(startDate,
  endDate);
  return doctorMapper.toListDto(findByDate);
  }

}
