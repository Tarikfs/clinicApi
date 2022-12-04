package br.com.tarikfs.exercicio.Clinic.repository;

import java.util.List;
import java.sql.Date;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tarikfs.exercicio.Clinic.model.MedicalAppointment;

@Repository
public interface MedicalAppointmentRepository
    extends JpaRepository<MedicalAppointment, UUID> {

  @Query("select a from MedicalAppointment a where (a.dateTimeAppointment) BETWEEN (:startDate) AND (:endDate)")
  List<MedicalAppointment> findByTimePeriod(@Param("startDate") Date startDate,
      @Param("endDate") Date endDate);

}
