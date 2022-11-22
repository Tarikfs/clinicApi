package br.com.tarikfs.exercicio.consultorio.dto.doctorsDtos;

import br.com.tarikfs.exercicio.consultorio.model.Doctor;

public class DoctorSumedUpDTO {

    private String crm;
    private String name;

    DoctorSumedUpDTO() {
    }

    public DoctorSumedUpDTO(Doctor doctor) {
        this.crm = doctor.getCrm();
        this.name = doctor.getName();
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
