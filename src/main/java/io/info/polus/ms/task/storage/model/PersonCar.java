package io.info.polus.ms.task.storage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonCar {
    private Long id;
    private Long personId;
    private Long carId;
}