package br.com.tarikfs.exercicio.consultorio.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.tarikfs.exercicio.consultorio.dto.doctorsDtos.DoctorDto;
import br.com.tarikfs.exercicio.consultorio.dto.doctorsDtos.DoctorRegistrationDto;
import br.com.tarikfs.exercicio.consultorio.model.Doctor;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface DoctorMapper {

    @Mapping(target = "id", ignore = true)
    Doctor toModel(DoctorDto doctorDto);

    DoctorDto toDto(Doctor doctor);

    @Mapping(target = "id", ignore = true)
    Doctor mapPutModel(DoctorRegistrationDto doctorRegistrationDto, @MappingTarget Doctor doctor);

    @Mapping(target = "id", ignore = true)
    Doctor toModelRegistration(DoctorRegistrationDto doctorRegistrationDto);

    DoctorRegistrationDto toDtoRegistration(Doctor doctor);

    List<DoctorDto> toListDto(List<Doctor> listAll);

    // DoctorSumedUpDTO toDtoSumedUp(Doctor doctor);

    @Mapping(target = "id", ignore = true)
    Doctor patchDoctor(DoctorRegistrationDto doctorRegistrationDto, @MappingTarget Doctor doctor);

}
