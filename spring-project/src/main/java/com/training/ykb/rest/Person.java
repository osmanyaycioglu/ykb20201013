package com.training.ykb.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.ykb.validation.StringStartValidation;


@XmlRootElement
public class Person {

    @Size(min = 2, max = 15, message = "Person name 2 ile 15 arasında olmalı.")
    @NotEmpty(message = "Person name boş olamaz.")
    private String  name;
    @StringStartValidation(startMy = "yay")
    private String  surname;
    @NotNull
    @Max(120)
    @Min(18)
    private Integer age;
    @StringStartValidation(startMy = "tur")
    private String  nationality;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(final String nationalityParam) {
        this.nationality = nationalityParam;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(final Integer ageParam) {
        this.age = ageParam;
    }


}
