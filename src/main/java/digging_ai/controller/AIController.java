package digging_ai.controller;

import digging_ai.dto.Response;
import digging_ai.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AIController {

    private final FileService fileService;

    public AIController(final FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/recommend/{memberId}")
    public Response getRecommendationForMember(@PathVariable String memberId) throws IOException {
        Resource resource = fileService.loadFile();
        Map<String, long[]> recommendations = fileService.readJsonFile(resource);

        long[] memberIdsArray = recommendations.getOrDefault(memberId, null);
        List<Long> memberIds = new ArrayList<>();

        for (long i : memberIdsArray) {
            memberIds.add(i);
        }
        return new Response(memberIds);
    }
}
