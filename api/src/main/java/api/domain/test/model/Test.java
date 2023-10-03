package api.domain.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private Long id;
    private String memo;
    private Integer amount;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;
}
