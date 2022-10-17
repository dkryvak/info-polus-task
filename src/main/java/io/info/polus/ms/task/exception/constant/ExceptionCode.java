package io.info.polus.ms.task.exception.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    INNER_SERVICE(1, 500);

    private final Integer code;
    private final Integer httpStatusCode;

}
