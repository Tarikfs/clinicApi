package br.com.tarikfs.exercicio.consultorio.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@MappedSuperclass
public abstract class User implements Serializable {

    protected static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    public UUID id;
    protected String name;
    @CPF
    protected String cpf;
    protected String birthDate;
    protected String sex;

    public User() {
    }

    public User(@Size(min = 1, max = 45) String name, @Length(min = 11, max = 11) @CPF String cpf, String birthDate,
            @Length(min = 1, max = 1) String sex) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
