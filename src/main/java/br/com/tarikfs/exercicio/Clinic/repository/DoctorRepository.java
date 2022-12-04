package br.com.tarikfs.exercicio.Clinic.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tarikfs.exercicio.Clinic.dto.doctorsDtos.DoctorDto;
import br.com.tarikfs.exercicio.Clinic.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
  Optional<Doctor> findByCrm(String crm);

  // @Query("SELECT d FROM Doctor d JOIN D.medicalAppointment ma WHERE ma.Patient = :patient")
  // List<Doctor> doctorByPatient(DoctorDto findByCrm);

  @Query("SELECT d FROM Doctor d INNER JOIN d.medicalAppointments ma WHERE ma.dateTimeAppointment BETWEEN (:startDate) AND (:endDate)")
  List<Doctor> findByTimePeriod(@Param("startDate") Date startDate,
      @Param("endDate") Date endDate);
}
