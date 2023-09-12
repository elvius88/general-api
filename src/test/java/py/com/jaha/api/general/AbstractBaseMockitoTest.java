package py.com.jaha.api.general;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractBaseMockitoTest {

    protected <T> T convertTo(String path, Class<T> class_) throws Exception {
        String jsonRequest = readJSON(path);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());

        return mapper.readValue(jsonRequest, class_);
    }

    protected String readJSON(String path) throws URISyntaxException, IOException {
        return new String(Files.readAllBytes(Paths.get(getClass().getResource(path).toURI())));
    }

    protected String readText(String path) throws IOException {
        return Files.readString(Path.of(path));
    }
    
    protected <T> T convertTo(String path, TypeReference<T> typeReference) throws Exception {
        String jsonRequest = readJSON(path);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());

        return mapper.readValue(jsonRequest, typeReference);
    }
}
