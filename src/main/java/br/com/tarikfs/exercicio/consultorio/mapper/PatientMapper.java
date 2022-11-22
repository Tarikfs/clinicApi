package br.com.tarikfs.exercicio.consultorio.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.tarikfs.exercicio.consultorio.dto.patientsDtos.PatientDto;
import br.com.tarikfs.exercicio.consultorio.dto.patientsDtos.PatientRegistrationDto;
import br.com.tarikfs.exercicio.consultorio.model.Patient;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PatientMapper {

    @Mapping(target = "id", ignore = true)
    Patient toModel(PatientDto patientDto);

    PatientDto toDto(Patient patient);

    @Mapping(target = "id", ignore = true)
    Patient mapPutModel(PatientRegistrationDto patientRegistrationDto, @MappingTarget Patient patient);

    @Mapping(target = "id", ignore = true)
    Patient toModelRegistration(PatientRegistrationDto patientRegistrationDto);

    PatientRegistrationDto toDtoRegistration(Patient patient);

    List<PatientDto> toListDto(List<Patient> listAll);

    // DoctorSumedUpDTO toDtoSumedUp(Doctor doctor);

    @Mapping(target = "id", ignore = true)
    Patient patchPatient(PatientRegistrationDto patientRegistrationDto, @MappingTarget Patient patient);

}
