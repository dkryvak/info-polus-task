package io.info.polus.ms.task.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import io.info.polus.ms.task.storage.model.car.Car;

public interface PersonCarService {

    Map<Long, List<Car>> groupAndGetMapByPersonIdIn(Collection<Long> personIds);

}