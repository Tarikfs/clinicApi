package br.com.tarikfs.exercicio.Clinic.controller;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

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

import br.com.tarikfs.exercicio.Clinic.dto.medicalappointmentsdtos.MedicalAppointmentDto;
import br.com.tarikfs.exercicio.Clinic.dto.medicalappointmentsdtos.MedicalAppointmentRegistrationDto;
import br.com.tarikfs.exercicio.Clinic.service.MedicalAppointmentService;

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

    @GetMapping(value = "/timePreriod")
    public ResponseEntity<List<MedicalAppointmentDto>> findByTimePeriod(@RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<MedicalAppointmentDto> list = medicalAppointmentService.findByTimePeriod(startDate, endDate);
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalAppointmentRegistrationDto> update(@PathVariable UUID id,
            @RequestBody MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(medicalAppointmentService.update(id, medicalAppointmentRegistrationDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MedicalAppointmentRegistrationDto> updatePatch(@PathVariable UUID id,
            @RequestBody MedicalAppointmentRegistrationDto medicalAppointmentRegistrationDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(medicalAppointmentService.update(id, medicalAppointmentRegistrationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        medicalAppointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}