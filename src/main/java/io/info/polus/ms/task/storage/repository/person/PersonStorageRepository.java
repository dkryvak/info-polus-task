package io.info.polus.ms.task.storage.repository.person;

import java.util.List;

import io.info.polus.ms.task.storage.model.person.Person;

public interface PersonStorageRepository {
 
    List<Person> findAll();

}