package io.info.polus.ms.task.exception.communication;

import io.info.polus.ms.task.exception.RemoteServicePassThroughException;
import io.info.polus.ms.task.exception.model.ServiceErrorDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestTemplateErrorHandler extends BaseResponseErrorHandler {

    @Override
    void handleError(ServiceErrorDto serviceErrorDto) {
        throw new RemoteServicePassThroughException(serviceErrorDto);
    }

}
