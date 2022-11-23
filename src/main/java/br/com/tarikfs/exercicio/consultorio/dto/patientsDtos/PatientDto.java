package br.com.tarikfs.exercicio.consultorio.dto.patientsDtos;

import java.util.UUID;

public class PatientDto {

    private UUID uuid;
    private String name;
    private String cpf;
    private String birthDate;
    private String sex;

    public PatientDto() {
    }

    public PatientDto(UUID uuid, String name, String cpf, String birthDate, String sex) {
        this.uuid = uuid;
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
