package br.com.tarikfs.exercicio.consultorio.repository;

import br.com.tarikfs.exercicio.consultorio.model.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAppointmentRepository
  extends JpaRepository<MedicalAppointment, Long> {}
