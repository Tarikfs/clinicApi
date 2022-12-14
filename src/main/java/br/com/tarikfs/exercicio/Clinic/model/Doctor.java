package br.com.tarikfs.exercicio.Clinic.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = " Doctor")
public class Doctor extends User {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    private List<MedicalAppointment> medicalAppointments;

    private String crm;

    public Doctor() {
    }

    public Doctor(@Size(min = 5, max = 5) String crm, @Size(min = 1, max = 45) String name,
            @Size(min = 11, max = 11) String cpf, @JsonFormat(pattern = "yyyy-MM-dd") String birthDate,
            @Size(min = 1, max = 1) String sex) {
        this.crm = crm;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.name = name;
        this.sex = sex;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<MedicalAppointment> getMedicalAppointments() {
        return medicalAppointments;
    }

    public void setMedicalAppointments(List<MedicalAppointment> medicalAppointments) {
        this.medicalAppointments = medicalAppointments;
    }

}
