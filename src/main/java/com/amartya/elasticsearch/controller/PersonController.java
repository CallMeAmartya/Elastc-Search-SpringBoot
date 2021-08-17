package com.amartya.elasticsearch.controller;

import com.amartya.elasticsearch.document.Person;
import com.amartya.elasticsearch.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
        log.info("service started : {}", service);
    }

    @PostMapping
    public void save(@RequestBody final Person person) {
        service.save(person);
        log.info("Person saved : {}", person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable final String id) {
        Person person = service.findById(id);
        log.info("Details retrieved by ID : {}", person);
        return person;
    }
}
