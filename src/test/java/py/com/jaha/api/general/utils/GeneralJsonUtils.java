package py.com.jaha.api.general.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GeneralJsonUtils {
    private static final ObjectMapper GENERAL_MAPPER = GeneralObjectMapper.buildObjectMapper() ;

    public static <T> T parseJson(Class<T> gClass, String path) throws IOException {

        File file = new File(path);
        T obj = GENERAL_MAPPER.readValue(file, gClass);
        return obj;
    }

    public static <T> List<T> parseJsonArray(Class<T[]> tRef,
                                             String path)   throws IOException {
        File file = new File(path);

        T[] objects = GENERAL_MAPPER.readValue(file, tRef);
        return Arrays.asList(objects);
    }

    public static byte[] toJson(Object object) throws IOException {
        GENERAL_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return GENERAL_MAPPER.writeValueAsBytes(object);
    }
}
