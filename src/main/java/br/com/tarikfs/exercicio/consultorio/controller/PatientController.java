package br.com.tarikfs.exercicio.consultorio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarikfs.exercicio.consultorio.dto.patientsDtos.PatientDto;
import br.com.tarikfs.exercicio.consultorio.dto.patientsDtos.PatientRegistrationDto;
import br.com.tarikfs.exercicio.consultorio.service.PatientService;

@RequestMapping(value = "/patient")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PatientDto> postPatient(@RequestBody PatientRegistrationDto patientRegistrationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.postPatient(patientRegistrationDto));
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getPatientByCpf(@RequestParam(required = false) String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatients(cpf));
    }

    @PutMapping(value = "/{cpf}")
    public ResponseEntity<PatientRegistrationDto> updatePatient(@PathVariable String cpf,
            @Valid @RequestBody PatientRegistrationDto patientRegistrationDto) {
        PatientRegistrationDto patient = patientService.updatePatient(cpf, patientRegistrationDto);
        return ResponseEntity.ok().body(patient);
    }

    @PatchMapping(value = "/{cpf}")
    public ResponseEntity<PatientRegistrationDto> patchPatient(@PathVariable String cpf,
            @Valid @RequestBody PatientRegistrationDto patientRegistrationDto) {
        PatientRegistrationDto patient = patientService.patchPatient(cpf, patientRegistrationDto);
        return ResponseEntity.ok().body(patient);
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<PatientDto> deletePatient(@PathVariable String cpf) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
