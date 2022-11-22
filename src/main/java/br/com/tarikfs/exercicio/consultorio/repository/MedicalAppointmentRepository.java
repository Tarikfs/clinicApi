package br.com.tarikfs.exercicio.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tarikfs.exercicio.consultorio.model.MedicalAppointment;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {

}
