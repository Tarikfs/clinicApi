package br.com.tarikfs.exercicio.consultorio.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tarikfs.exercicio.consultorio.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT * FROM patient WHERE cpf = ?1")
    Optional<Patient> findByCpf(String cpf);
}
