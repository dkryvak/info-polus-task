package io.info.polus.ms.task.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.info.polus.ms.task.storage.model.PersonCar;
import io.info.polus.ms.task.storage.model.car.Car;
import io.info.polus.ms.task.storage.repository.PersonCarStorageRepository;
import io.info.polus.ms.task.storage.repository.car.CarStorageRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonCarServiceImpl implements PersonCarService {

    private final CarStorageRepository carStorageRepository;
    private final PersonCarStorageRepository personCarStorageRepository;

    @Override
    public Map<Long, List<Car>> groupAndGetMapByPersonIdIn(Collection<Long> personIds) {
        var personCars = personCarStorageRepository.findAllByPersonIdIn(personIds);
        var carIds = personCars.stream()
                .map(PersonCar::getCarId)
                .collect(Collectors.toSet());

        var carsMap = carStorageRepository.findAllByIdIn(carIds).stream()
                .collect(Collectors.toMap(Car::getId, Function.identity()));

        return personCars.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(PersonCar::getPersonId),
                        map -> map.entrySet().stream()
                                .map(entry -> {
                                    var cars = entry.getValue().stream()
                                            .map(PersonCar::getCarId)
                                            .filter(carsMap::containsKey)
                                            .map(carsMap::get)
                                            .collect(Collectors.toList());

                                    return Map.entry(entry.getKey(), cars);
                                })
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))));
    }

}