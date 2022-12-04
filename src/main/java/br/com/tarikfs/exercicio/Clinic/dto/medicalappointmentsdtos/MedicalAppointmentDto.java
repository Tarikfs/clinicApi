package br.com.tarikfs.exercicio.Clinic.dto.medicalappointmentsdtos;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MedicalAppointmentDto {
  private UUID uuid;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date dateTimeAppointment;
  private String observation;
  private boolean active;
  private String crm;
  private String patientCpf;

  public MedicalAppointmentDto() {
  }

  public MedicalAppointmentDto(
      UUID uuid,
      Date dateTimeAppointment,
      String observation,
      boolean active,
      String crm,
      String patientCpf) {
    this.uuid = uuid;
    this.dateTimeAppointment = dateTimeAppointment;
    this.observation = observation;
    this.active = active;
    this.crm = crm;
    this.patientCpf = patientCpf;
  }

  public void setDateTimeAppointment(Date dateTimeAppointment) {
    this.dateTimeAppointment = dateTimeAppointment;
  }

  public Date getDateTimeAppointment() {
    return dateTimeAppointment;
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

  public void setCrm(String crm) {
    this.crm = crm;
  }

  public String getCrm() {
    return crm;
  }

  public void setPatientCpf(String patientCpf) {
    this.patientCpf = patientCpf;
  }

  public String getPatientCpf() {
    return patientCpf;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
