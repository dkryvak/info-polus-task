package io.info.polus.ms.task.storage.repository;

import java.util.Collection;
import java.util.List;

import io.info.polus.ms.task.storage.model.PersonCar;

public interface PersonCarStorageRepository {

    List<PersonCar> findAll();

    List<PersonCar> findAllByPersonIdIn(Collection<Long> personIds);

}