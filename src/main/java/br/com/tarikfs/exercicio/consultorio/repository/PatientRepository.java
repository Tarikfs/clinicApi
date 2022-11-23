package br.com.tarikfs.exercicio.consultorio.repository;

import br.com.tarikfs.exercicio.consultorio.model.Patient;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
  Optional<Patient> findByCpf(String cpf);
}
