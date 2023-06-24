package kr.co.devhanjong.hj_error_code_module.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component("commonModuleJsonUtil")
public class JsonUtil {
    private final ObjectMapper mapper;

    /**
     *  json값이 json 타입이 맞는지 확인합니다.
     * @return
     */
    public static boolean maybeJson(String json) {
        return json != null && !"null".equals(json)
                && ((json.startsWith("[") && json.endsWith("]"))
                || (json.startsWith("{") && json.endsWith("}")));
    }

    /**
     * json 값이 Json타입이면서 값이 비어있지 않은지 확인합니다.
     *
     * @param json
     * @return
     */
    public static boolean maybeJsonAndNotEmpty(String json){
        return maybeJson(json) && !"[]".equals(json) && !"{}".equals(json);
    }


    private JsonUtil() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.AUTO_DETECT_GETTERS, true);
        mapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
    }

    public static JsonUtil getInstance() {
        return new JsonUtil();
    }

    private static ObjectMapper getMapper() {
        return getInstance().mapper;
    }


    public static <T> T fromJson(String jsonStr, Class<T> cls) {
        try {
            return getMapper().readValue(jsonStr, cls);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String jsonStr, TypeReference<T> typeReference) {
        try {
            return getMapper().readValue(jsonStr, typeReference);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode fromJson(String json) throws Exception {
        try {
            return getMapper().readTree(json);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static <T extends Collection> T fromJson(String jsonStr, CollectionType collectionType) {
        try {
            return getMapper().readValue(jsonStr, collectionType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toPrettyJson(String json) {
        Object jsonObject = JsonUtil.fromJson(json, Object.class);
        try {
            return getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

}
