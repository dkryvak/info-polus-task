package io.info.polus.ms.task.exception.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.info.polus.ms.task.exception.constant.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceErrorDto {
    private Integer code;
    private Integer httpStatusCode;
    private Map<String, String> args;
    private String debugMessage;

    public static ServiceErrorDto of(ExceptionCode exceptionCode, String debugMessage) {
        return of(exceptionCode, Map.of(), debugMessage);
    }

    public static ServiceErrorDto of(ExceptionCode exceptionCode, Map<String, String> args, String debugMessage) {
        return new ServiceErrorDto(exceptionCode.getCode(), exceptionCode.getHttpStatusCode(), args, debugMessage);
    }
}
