package io.info.polus.ms.task.service.person;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.info.polus.ms.task.converter.PersonConverter;
import io.info.polus.ms.task.service.PersonCarService;
import io.info.polus.ms.task.storage.model.person.Person;
import io.info.polus.ms.task.storage.repository.person.PersonStorageRepository;
import io.info.polus.ms.task.web.dto.PersonDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonStorageRepository personStorageRepository;

    private final PersonCarService personCarService;

    @Override
    public List<PersonDto> getAll() {
        var persons = personStorageRepository.findAll();
        var personIds = persons.stream()
                .map(Person::getId)
                .collect(Collectors.toSet());

        var personCarsMap = personCarService.groupAndGetMapByPersonIdIn(personIds);

        return persons.stream()
                .map(person -> PersonConverter.toDto(person, personCarsMap.getOrDefault(person.getId(), List.of())))
                .collect(Collectors.toList());
    }

}