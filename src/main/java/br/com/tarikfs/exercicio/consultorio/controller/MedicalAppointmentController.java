package br.com.tarikfs.exercicio.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarikfs.exercicio.consultorio.dto.MedicalAppointmentsDtos.MedicalAppointmentDto;
import br.com.tarikfs.exercicio.consultorio.dto.MedicalAppointmentsDtos.MedicalAppointmentRegistrationDto;
import br.com.tarikfs.exercicio.consultorio.service.MedicalAppointmentService;

@RequestMapping(value = "/medicalappoinment")
@RestController
public class MedicalAppointmentController {

    @Autowired
    private MedicalAppointmentService medicalAppointmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MedicalAppointmentDto> create(
            @RequestBody MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(medicalAppointmentService.create(medicalAppointmentRegistrationDto));
    }

    @GetMapping
    public ResponseEntity<List<MedicalAppointmentDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(medicalAppointmentService.findAll());
    }

}