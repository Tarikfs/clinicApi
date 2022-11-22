package br.com.tarikfs.exercicio.consultorio.dto.MedicalAppointmentsDtos;

import java.sql.Date;

import br.com.tarikfs.exercicio.consultorio.dto.doctorsDtos.DoctorDto;
import br.com.tarikfs.exercicio.consultorio.dto.patientsDtos.PatientDto;

public class MedicalAppointmentDto {

    private Date dateTime;
    private String observation;
    private boolean active;
    public DoctorDto doctor;
    public PatientDto patient;

    public MedicalAppointmentDto() {
    }

    public MedicalAppointmentDto(Date dateTime, String observation, boolean active, DoctorDto doctor,
            PatientDto patient) {
        this.dateTime = dateTime;
        this.observation = observation;
        this.active = active;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
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

    public DoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

}
