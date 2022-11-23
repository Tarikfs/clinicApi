package br.com.tarikfs.exercicio.consultorio.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.tarikfs.exercicio.consultorio.dto.doctorsDtos.DoctorDto;
import br.com.tarikfs.exercicio.consultorio.dto.doctorsDtos.DoctorRegistrationDto;
import br.com.tarikfs.exercicio.consultorio.model.Doctor;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(target = "id", ignore = true)
    Doctor toModelRegistration(DoctorRegistrationDto doctorRegistrationDto);

    @Mapping(target = "uuid", source = "id")
    DoctorDto toDto(Doctor doctorModel);

    List<DoctorDto> toListDto(List<Doctor> doctors);

    DoctorRegistrationDto toDtoRegistration(Doctor doctorModel);

    @Mapping(target = "id", ignore = true)
    Doctor mapPutModel(DoctorRegistrationDto doctorRegistrationDto, @MappingTarget Doctor doctorModel);

    @Mapping(target = "id", ignore = true)
    Doctor patchDoctor(DoctorRegistrationDto doctorRegistrationDto, @MappingTarget Doctor doctorModel);

}
