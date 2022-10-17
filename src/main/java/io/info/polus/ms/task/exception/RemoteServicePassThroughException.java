package io.info.polus.ms.task.exception;

import java.util.Objects;

import io.info.polus.ms.task.exception.model.ServiceErrorDto;
import lombok.Getter;

@Getter
public class RemoteServicePassThroughException extends RuntimeException {

    private final ServiceErrorDto serviceErrorDto;

    public RemoteServicePassThroughException(ServiceErrorDto serviceErrorDto) {
        super(Objects.isNull(serviceErrorDto.getDebugMessage()) ? "Unknown remote service error."
                : serviceErrorDto.getDebugMessage());
        this.serviceErrorDto = serviceErrorDto;
    }

}
