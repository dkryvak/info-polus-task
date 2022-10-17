package io.info.polus.ms.task.storage.repository.person;

import java.util.List;

import org.springframework.stereotype.Component;

import io.info.polus.ms.task.storage.model.person.Person;

@Component
public class PersonStorageRepositoryImpl implements PersonStorageRepository {

    @Override
    public List<Person> findAll() {
        return List.of(
                new Person(1L, "Markus"),
                new Person(2L, "Phillip"),
                new Person(3L, "Nana"),
                new Person(4L, "Kira"),
                new Person(5L, "Timothy"));
    }

}