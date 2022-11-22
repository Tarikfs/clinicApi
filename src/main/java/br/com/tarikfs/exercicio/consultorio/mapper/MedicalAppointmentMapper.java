package br.com.tarikfs.exercicio.consultorio.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.tarikfs.exercicio.consultorio.dto.MedicalAppointmentsDtos.MedicalAppointmentDto;
import br.com.tarikfs.exercicio.consultorio.dto.MedicalAppointmentsDtos.MedicalAppointmentPatchDto;
import br.com.tarikfs.exercicio.consultorio.dto.MedicalAppointmentsDtos.MedicalAppointmentRegistrationDto;
import br.com.tarikfs.exercicio.consultorio.dto.MedicalAppointmentsDtos.MedicalAppointmentSumedUpDto;
import br.com.tarikfs.exercicio.consultorio.model.MedicalAppointment;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MedicalAppointmentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "doctor.id", ignore = true)
    @Mapping(target = "patient.id", ignore = true)
    MedicalAppointment toModel(MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto);

    MedicalAppointmentDto toDto(MedicalAppointment medicalAppointment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "doctor.id", ignore = true)
    @Mapping(target = "patient.id", ignore = true)
    MedicalAppointment mapPutModel(MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto,
                    @MappingTarget MedicalAppointment MedicalAppointment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "doctor.id", ignore = true)
    @Mapping(target = "patient.id", ignore = true)
    MedicalAppointment mapPatchModel(MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto,
                    @MappingTarget MedicalAppointment MedicalAppointment);

    MedicalAppointmentSumedUpDto toSumedUpDto(MedicalAppointment medicalAppointment);

    MedicalAppointmentRegistrationDto toDtoRegistration(MedicalAppointment medicalAppointment);

    List<MedicalAppointmentDto> toListDto(List<MedicalAppointment> listAll);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateTime", ignore = true)
    MedicalAppointment mapPatchModel(MedicalAppointmentPatchDto medicalAppointmentPatchDto,
                    @MappingTarget MedicalAppointment medicalAppointment);
}