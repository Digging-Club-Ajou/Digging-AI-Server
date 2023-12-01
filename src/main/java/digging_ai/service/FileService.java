package digging_ai.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import digging_ai.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
public class FileService {

    private final ObjectMapper objectMapper;

    public FileService(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Response readJsonFile() {
        Path filePath = Paths.get("/home/ec2-user/recommend.json");
        String jsonString = null;
        try {
            jsonString = Files.readString(filePath);
        } catch (IOException e) {
            log.info("IOException occur");
        }
        try {
            return objectMapper.readValue(jsonString, Response.class);
        } catch (JsonProcessingException e) {
            log.info("JsonProcessingException occur");
        }

        return null;
    }
}
