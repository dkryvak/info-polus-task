package io.info.polus.ms.task.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import io.info.polus.ms.task.storage.model.car.Car;
import io.info.polus.ms.task.web.dto.CarDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CarConverter {

    public static CarDto toDto(Car car) {
        return new CarDto(car.getId(), car.getName());
    }

    public static List<CarDto> toDtos(Collection<Car> cars) {
        return cars.stream()
                .map(CarConverter::toDto)
                .collect(Collectors.toList());
    }

}