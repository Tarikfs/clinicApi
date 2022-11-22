package br.com.tarikfs.exercicio.consultorio.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tarikfs.exercicio.consultorio.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT * FROM doctor WHERE crm = ?1")
    Optional<Doctor> findByCrm(String crm);

}
