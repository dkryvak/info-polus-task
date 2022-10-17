package io.info.polus.ms.task.storage.repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.info.polus.ms.task.storage.model.PersonCar;

@Component
public class PersonCarStorageRepositoryImpl implements PersonCarStorageRepository {

    @Override
    public List<PersonCar> findAll() {
        return List.of(
                new PersonCar(1L, 1L, 3L),
                new PersonCar(2L, 2L, 4L),
                new PersonCar(3L, 2L, 1L),
                new PersonCar(4L, 3L, 2L),
                new PersonCar(5L, 4L, 4L),
                new PersonCar(6L, 1L, 5L));
    }

    @Override
    public List<PersonCar> findAllByPersonIdIn(Collection<Long> personIds) {
        return findAll().stream()
                .filter(personCar -> personIds.contains(personCar.getPersonId()))
                .collect(Collectors.toList());
    }

}