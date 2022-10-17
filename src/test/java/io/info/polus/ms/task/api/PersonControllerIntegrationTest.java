package io.info.polus.ms.task.api;

import static io.info.polus.ms.task.utility.ResponseBodyMatchers.responseBody;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.type.TypeReference;

import io.info.polus.ms.task.storage.model.PersonCar;
import io.info.polus.ms.task.storage.model.car.Car;
import io.info.polus.ms.task.storage.model.person.Person;
import io.info.polus.ms.task.storage.repository.PersonCarStorageRepository;
import io.info.polus.ms.task.storage.repository.car.CarStorageRepository;
import io.info.polus.ms.task.storage.repository.person.PersonStorageRepository;
import io.info.polus.ms.task.web.dto.CarDto;
import io.info.polus.ms.task.web.dto.PersonDto;

public class PersonControllerIntegrationTest extends BaseControllerIntegrationTest {

    @MockBean
    private PersonStorageRepository personStorageRepository;
    @MockBean
    private CarStorageRepository carStorageRepository;
    @MockBean
    private PersonCarStorageRepository personCarStorageRepository;

    @Test
    void whenGetPersonDtos_thenReturns200() throws Exception {
        var persons = List.of(new Person(1L, "Denys"));
        var cars = List.of(new Car(1L, "Toyota"), new Car(2L, "Nissan"));
        var personCars = List.of(new PersonCar(1L, 1L, 1L), new PersonCar(2L, 1L, 2L));

        var carDtos = List.of(new CarDto(1L, "Toyota"), new CarDto(2L, "Nissan"));
        var personDtos = List.of(new PersonDto(1L, "Denys", carDtos));

        when(personStorageRepository.findAll()).thenReturn(persons);

        when(personCarStorageRepository.findAllByPersonIdIn(anyCollection())).thenReturn(personCars);

        when(carStorageRepository.findAllByIdIn(anyCollection())).thenReturn(cars);

        mockMvc.perform(get("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(responseBody().containsObjectAsJson(personDtos, new TypeReference<List<PersonDto>>() {
                }));
    }

}