package io.info.polus.ms.task.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.info.polus.ms.task.service.person.PersonService;
import io.info.polus.ms.task.web.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDto> getAll() {
        log.info("Request to get all person received.");
        var personDtos = personService.getAll();
        log.info("Response on get all person. Size = {}", personDtos.size());
        return personDtos;
    }

}
