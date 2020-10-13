package com.training.ykb.rest;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Person {

    @NotEmpty
    private String  name;
    private String  surname;
    private Integer age;
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
