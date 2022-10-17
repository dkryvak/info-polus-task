package io.info.polus.ms.task.converter;

import java.util.List;

import io.info.polus.ms.task.storage.model.car.Car;
import io.info.polus.ms.task.storage.model.person.Person;
import io.info.polus.ms.task.web.dto.PersonDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PersonConverter {

    public static PersonDto toDto(Person person, List<Car> cars) {
        var carDtos = CarConverter.toDtos(cars);
        return new PersonDto(person.getId(), person.getName(), carDtos);
    }

    public static PersonDto toDto(Person person) {
        return toDto(person, List.of());
    }

}