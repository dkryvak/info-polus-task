package io.info.polus.ms.task.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.springframework.test.web.servlet.ResultMatcher;

public final class ResponseBodyMatchers {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> ResultMatcher containsObjectAsJson(Object expectedObject, Class<T> actualObjectClass) {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            T actualObject = objectMapper.readValue(json, actualObjectClass);

            Assertions.assertThat(actualObject)
                    .usingRecursiveComparison()
                    .isEqualTo(expectedObject);
        };
    }

    public <T> ResultMatcher containsObjectAsJson(Object expectedObject, TypeReference<T> actualObjectTypeReference) {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            T actualObject = objectMapper.readValue(json, actualObjectTypeReference);

            Assertions.assertThat(actualObject)
                    .usingRecursiveComparison()
                    .isEqualTo(expectedObject);
        };
    }

    public static ResponseBodyMatchers responseBody(){
        return new ResponseBodyMatchers();
    }
}
