package io.info.polus.ms.task.service.person;

import java.util.List;

import io.info.polus.ms.task.web.dto.PersonDto;

public interface PersonService {

    List<PersonDto> getAll();

}