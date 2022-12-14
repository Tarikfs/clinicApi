package br.com.tarikfs.exercicio.Clinic.controller;

import java.sql.Date;
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

import br.com.tarikfs.exercicio.Clinic.dto.doctorsDtos.DoctorDto;
import br.com.tarikfs.exercicio.Clinic.dto.doctorsDtos.DoctorRegistrationDto;
import br.com.tarikfs.exercicio.Clinic.service.DoctorService;

@RequestMapping(value = "/doctor")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DoctorDto> postDoctor(@RequestBody DoctorRegistrationDto doctorRegistrationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.postDoctor(doctorRegistrationDto));
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getDoctorByCrm(@RequestParam(required = false) String crm) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getsAllDoctors(crm));
    }



    @GetMapping(value = "/timeperiod")
    public ResponseEntity<List<DoctorDto>> findByTimePeriod(@RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<DoctorDto> list = doctorService.findByTimePeriod(startDate, endDate);
        return ResponseEntity.ok().body(list);
    }

    
    @PutMapping(value = "/{crm}")
    public ResponseEntity<DoctorRegistrationDto> updateDoctor(@PathVariable String crm,
            @Valid @RequestBody DoctorRegistrationDto doctorRegistrationDto) {
        DoctorRegistrationDto doctor = doctorService.updateDoctor(crm, doctorRegistrationDto);
        return ResponseEntity.ok().body(doctor);
    }

    @PatchMapping(value = "/{crm}")
    public ResponseEntity<DoctorRegistrationDto> patchDoctor(@PathVariable String crm,
            @Valid @RequestBody DoctorRegistrationDto doctorRegistrationDto) {
        DoctorRegistrationDto doctor = doctorService.patchDoctor(crm, doctorRegistrationDto);
        return ResponseEntity.ok().body(doctor);
    }

    @DeleteMapping(value = "/{crm}")
    public ResponseEntity<DoctorDto> deleteDoctor(@PathVariable String crm) {
        return ResponseEntity.ok().body(doctorService.deleteDoctor(crm));
    }
}
