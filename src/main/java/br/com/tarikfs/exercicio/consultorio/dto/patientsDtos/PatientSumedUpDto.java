package br.com.tarikfs.exercicio.consultorio.dto.patientsDtos;

public class PatientSumedUpDto {

    private String name;
    private String cpf;

    public PatientSumedUpDto() {
    }

    public PatientSumedUpDto(String name, String cpf) {

        this.name = name;
        this.cpf = cpf;
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

}
