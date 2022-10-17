package io.info.polus.ms.task.storage.repository.car;

import java.util.Collection;
import java.util.List;

import io.info.polus.ms.task.storage.model.car.Car;

public interface CarStorageRepository {
    
    List<Car> findAll();

    List<Car> findAllByIdIn(Collection<Long> ids);

}