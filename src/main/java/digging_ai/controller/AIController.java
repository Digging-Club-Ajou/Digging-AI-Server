package digging_ai.controller;

import digging_ai.dto.Response;
import digging_ai.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {

    private final FileService fileService;

    public AIController(final FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/recommend")
    public Response getRecommendationForMember() {
        return fileService.readJsonFile();
    }
}
