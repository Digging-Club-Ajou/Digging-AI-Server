package digging_ai.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class FileService {

    private final ObjectMapper objectMapper;

    public FileService(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Resource loadFile() throws IOException {
        // 파일 경로 설정
        Path filePath = Paths.get("/home/ec2-user/recommend.json");
        Resource resource = new UrlResource(filePath.toUri());

        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new IOException("Could not read the file");
        }
    }

    public Map<String, long[]> readJsonFile(Resource resource) throws IOException {
        return objectMapper.readValue(resource.getInputStream(), Map.class);
    }
}
