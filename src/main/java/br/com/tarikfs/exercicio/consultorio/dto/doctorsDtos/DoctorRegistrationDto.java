package br.com.tarikfs.exercicio.consultorio.dto.doctorsDtos;

public class DoctorRegistrationDto {

    private String name;
    private String cpf;
    private String birthDate;
    private String sex;
    private String crm;

    public DoctorRegistrationDto() {
    }

    public DoctorRegistrationDto(String name, String cpf, String birthDate, String sex, String crm) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.sex = sex;
        this.crm = crm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    

  
}
