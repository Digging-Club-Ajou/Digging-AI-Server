package digging_ai.dto;

import java.util.List;
import java.util.Map;

public record Response(
        Map<Long, List<Long>> memberIds
) {
}
