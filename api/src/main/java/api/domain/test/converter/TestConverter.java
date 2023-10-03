package api.domain.test.converter;

import api.common.annotation.Converter;
import api.common.error.ErrorCode;
import api.common.exception.ApiException;
import api.domain.test.model.TestResponse;
import db.test.TestEntity;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Converter
@RequiredArgsConstructor
public class TestConverter {


    public TestResponse toResponse(TestEntity testEntity) {

        return Optional.ofNullable(testEntity)
                .map(it -> {
                    // to response
                    return TestResponse.builder()
                            .id(testEntity.getId())
                            .memo(testEntity.getMemo())
                            .amount(testEntity.getAmount())
                            .modifiedAt(testEntity.getModifiedAt())
                            .createdAt(testEntity.getCreatedAt())
                            .build();
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "TestEntity Null"));
    }
}
