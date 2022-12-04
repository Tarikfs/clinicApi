package br.com.tarikfs.exercicio.Clinic.dto.medicalappointmentsdtos;

import java.sql.Date;

import br.com.tarikfs.exercicio.Clinic.model.Doctor;
import br.com.tarikfs.exercicio.Clinic.model.Patient;

public class MedicalAppointmentPatchDto {

    private Date date;
    private String observation;
    private boolean active;

    private Doctor doctor;
    private Patient patient;

    public MedicalAppointmentPatchDto() {
    }

    public MedicalAppointmentPatchDto(Date date, String observation, boolean active, Doctor doctor,
            Patient patient) {
        this.date = date;
        this.observation = observation;
        this.active = active;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
