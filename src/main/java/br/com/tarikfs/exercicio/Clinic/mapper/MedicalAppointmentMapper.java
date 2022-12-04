package br.com.tarikfs.exercicio.Clinic.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.tarikfs.exercicio.Clinic.dto.medicalappointmentsdtos.MedicalAppointmentDto;
import br.com.tarikfs.exercicio.Clinic.dto.medicalappointmentsdtos.MedicalAppointmentRegistrationDto;
import br.com.tarikfs.exercicio.Clinic.model.MedicalAppointment;

@Mapper(componentModel = "spring")
public interface MedicalAppointmentMapper {

        @Mapping(target = "doctor", ignore = true)
        @Mapping(target = "patient", ignore = true)
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "active", ignore = true)
        MedicalAppointment toModel(
                        MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto);

        @Mapping(target = "crm", source = "doctor.crm")
        @Mapping(target = "patientCpf", source = "patient.cpf")
        @Mapping(target = "uuid", source = "id")
        MedicalAppointmentDto toDto(MedicalAppointment medicalAppointment);

        List<MedicalAppointmentDto> toListDto(
                        List<MedicalAppointment> medicalAppointments);

        @Mapping(target = "doctor", ignore = true)
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "patient", ignore = true)
        @Mapping(target = "active", ignore = true)
        MedicalAppointment mapPutModel(
                        MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto,
                        @MappingTarget MedicalAppointment medicalAppointment);

        @Mapping(target = "doctorUuid", ignore = true)
        @Mapping(target = "patientUuid", ignore = true)
        MedicalAppointmentRegistrationDto toDtoRegistration(
                        MedicalAppointment medicalAppointment);

        @Mapping(target = "doctor", ignore = true)
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "patient", ignore = true)
        @Mapping(target = "active", ignore = true)
        MedicalAppointment mapPatchModel(
                        MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto,
                        @MappingTarget MedicalAppointment medicalAppointment);
}
