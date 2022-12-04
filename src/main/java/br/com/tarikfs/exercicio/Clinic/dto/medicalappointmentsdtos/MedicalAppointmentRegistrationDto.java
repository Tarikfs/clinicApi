package br.com.tarikfs.exercicio.Clinic.dto.medicalappointmentsdtos;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MedicalAppointmentRegistrationDto {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateTimeAppointment;
    private String observation;
    private UUID doctorUuid;
    private UUID patientUuid;

    public MedicalAppointmentRegistrationDto() {
    }

    public MedicalAppointmentRegistrationDto(Date dateTimeAppointment, String observation, UUID doctorUuid,
            UUID patientUuid) {
        this.dateTimeAppointment = dateTimeAppointment;
        this.observation = observation;
        this.doctorUuid = doctorUuid;
        this.patientUuid = patientUuid;
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

    public UUID getDoctorUuid() {
        return doctorUuid;
    }

    public void setDoctorUuid(UUID doctorUuid) {
        this.doctorUuid = doctorUuid;
    }

    public UUID getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(UUID patientUuid) {
        this.patientUuid = patientUuid;
    }

}
