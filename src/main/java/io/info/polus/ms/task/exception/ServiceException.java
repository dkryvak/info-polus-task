package io.info.polus.ms.task.exception;

import java.util.Map;

import io.info.polus.ms.task.exception.constant.ExceptionCode;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private final ExceptionCode code;
    private final Map<String, String> args;

    public ServiceException(ExceptionCode code, String message) {
        this(code, Map.of(), message);
    }

    public ServiceException(ExceptionCode code, Map<String, String> args, String message) {
        super(message);
        this.code = code;
        this.args = args;
    }

}
