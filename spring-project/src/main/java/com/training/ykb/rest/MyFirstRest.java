package com.training.ykb.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class MyFirstRest {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/hello")
    public String helloPost() {
        return "hello Post world";
    }

    @PutMapping("/hello")
    public String hello2() {
        return "hello Put world";
    }

    @DeleteMapping("/hello")
    public String hello3() {
        return "hello Delete world";
    }

    @PatchMapping("/hello")
    public String hello4() {
        return "hello Patch world";
    }

    @GetMapping("/hello5/{xyz}/{abc}")
    public String hello5(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname,
                         @RequestParam("yas") final int age) {
        return "hello world 5" + name + " " + surname + " " + age;
    }

    @GetMapping("/hello6")
    public String hello6(@RequestParam("isim") final String name,
                         @RequestParam("soy") final String surname) {
        return "hello world 6 " + name + " " + surname;
    }

    @GetMapping("/hello7")
    public String hello7(@RequestHeader("isim") final String name,
                         @RequestHeader("soy") final String surname) {
        return "hello world 7 " + name + " " + surname;
    }

    @PostMapping("/hello8")
    public String hello8(@RequestBody final Person person) {
        return "hello world 8 "
               + person.getName()
               + " "
               + person.getSurname()
               + " "
               + person.getAge()
               + " "
               + person.getNationality();
    }

    @PostMapping("/hello9")
    public Person hello9(@RequestBody final Person person) {
        person.setName("ali");
        return person;
    }

    @PostMapping(value = "/hello10",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person hello10(@RequestBody final Person person) {
        person.setName("ali");
        return person;
    }


    @PostMapping("/hello11")
    public Person hello11(@Validated @RequestBody final Person person) {
        if ((person.getNationality() == null)
            || person.getName()
                     .isEmpty()) {
            throw new IllegalArgumentException("Nationality null olamaz");
        }
        person.setName("ali");
        return person;
    }

    //    @ExceptionHandler(Exception.class)
    //    public void handleError(final Exception exceptionParam) {
    //        if (exceptionParam instanceof IllegalArgumentException) {
    //            IllegalArgumentException argumentExceptionLoc = (IllegalArgumentException) exceptionParam;
    //
    //        } else if (exceptionParam instanceof MethodArgumentNotValidException) {
    //            MethodArgumentNotValidException argumentNotValidExceptionLoc = (MethodArgumentNotValidException) exceptionParam;
    //
    //        }
    //    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleIllegalArgumentException(final IllegalArgumentException exceptionParam) {
        ErrorObject errorObjectLoc = new ErrorObject();
        errorObjectLoc.setBoundedContext("IT-CRM");
        errorObjectLoc.setSubDomain("IT");
        errorObjectLoc.setMicroservice("Spring proj");
        errorObjectLoc.setErrorDesc(exceptionParam.getMessage());
        errorObjectLoc.setErrorCause(1001);
        return errorObjectLoc;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleMethodArgumentNotValidException(final MethodArgumentNotValidException exceptionParam) {
        ErrorObject errorObjectLoc = new ErrorObject();
        errorObjectLoc.setBoundedContext("IT-CRM");
        errorObjectLoc.setSubDomain("IT");
        errorObjectLoc.setMicroservice("Spring proj");
        errorObjectLoc.setErrorDesc("Validation Error");
        errorObjectLoc.setErrorCause(1001);
        List<ObjectError> allErrorsLoc = exceptionParam.getBindingResult()
                                                       .getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            ErrorObject c = new ErrorObject();
            c.setBoundedContext("IT-CRM");
            c.setSubDomain("IT");
            c.setMicroservice("Spring proj");
            c.setErrorDesc(objectErrorLoc.toString());
            c.setErrorCause(1001);
            errorObjectLoc.addChild(c);
        }
        return errorObjectLoc;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObject handleError(final Exception exceptionParam) {
        ErrorObject errorObjectLoc = new ErrorObject();
        errorObjectLoc.setBoundedContext("IT-CRM");
        errorObjectLoc.setSubDomain("IT");
        errorObjectLoc.setMicroservice("Spring proj");
        errorObjectLoc.setErrorDesc(exceptionParam.getMessage());
        errorObjectLoc.setErrorCause(1001);
        return errorObjectLoc;
    }

}

