package br.com.tarikfs.exercicio.consultorio.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = " Patient")
public class Patient extends User {

    public Patient() {
    }

    public Patient(@Size(min = 1, max = 45) String name, @Size(min = 1, max = 45) String cpf,
            @JsonFormat(pattern = "yyyy-MM-dd") String birthDate, @Size(min = 1, max = 1) String sex) {
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
    }


}
