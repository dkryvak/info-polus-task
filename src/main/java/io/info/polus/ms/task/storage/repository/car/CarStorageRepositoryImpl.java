package io.info.polus.ms.task.storage.repository.car;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.info.polus.ms.task.storage.model.car.Car;

@Component
public class CarStorageRepositoryImpl implements CarStorageRepository {

    @Override
    public List<Car> findAll() {
        return List.of(
                new Car(1L, "Toyota"),
                new Car(2L, "Kia"),
                new Car(3L, "Mercedes-Benz"),
                new Car(4L, "Hyundai"));
    }

    @Override
    public List<Car> findAllByIdIn(Collection<Long> ids) {
        return findAll().stream()
                .filter(person -> ids.contains(person.getId()))
                .collect(Collectors.toList());
    }

}