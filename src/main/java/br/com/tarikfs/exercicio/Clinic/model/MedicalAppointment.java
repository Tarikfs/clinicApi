package br.com.tarikfs.exercicio.Clinic.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MedicalAppointment implements Serializable {

    protected static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id", updatable = false, unique = true, nullable = false)
    private UUID id;

    private Date dateTimeAppointment;

    protected String observation;

    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Doctor doctor;

    private Patient patient;

    public MedicalAppointment() {
    }

    public MedicalAppointment(Date dateTimeAppointment, String observation, Doctor doctor, Patient patient) {
        this.dateTimeAppointment = dateTimeAppointment;
        this.observation = observation;
        this.doctor = doctor;
        this.patient = patient;
        this.active = true;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDateTimeAppointment() {
        return dateTimeAppointment;
    }

    public void setDateTimeAppointment(Date dateTimeAppointment) {
        this.dateTimeAppointment = dateTimeAppointment;
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
