package api.domain.test.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TestResponse {
    private Long id;
    private String memo;
    private Integer amount;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;
}
