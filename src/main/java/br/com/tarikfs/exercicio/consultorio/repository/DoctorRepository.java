package br.com.tarikfs.exercicio.consultorio.repository;

import br.com.tarikfs.exercicio.consultorio.model.Doctor;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
  //   @Query("SELECT * FROM doctor WHERE crm = ?1")
  Optional<Doctor> findByCrm(String crm);
}
