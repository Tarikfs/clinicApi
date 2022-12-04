package br.com.tarikfs.exercicio.Clinic.dto.medicalappointmentsdtos;

import br.com.tarikfs.exercicio.Clinic.model.Doctor;
import br.com.tarikfs.exercicio.Clinic.model.Patient;

public class MedicalAppointmentSumedUpDto {

    private Patient patient;
    private Doctor doctor;
    private boolean active;


    public MedicalAppointmentSumedUpDto() {
    }

    public MedicalAppointmentSumedUpDto(Patient patient, Doctor doctor, boolean active) {
        this.patient = patient;
        this.doctor = doctor;
        this.active = active;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
