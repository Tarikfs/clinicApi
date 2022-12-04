package br.com.tarikfs.exercicio.Clinic.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tarikfs.exercicio.Clinic.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
  Optional<Patient> findByCpf(String cpf);
}
