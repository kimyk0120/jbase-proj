package api.domain.test.service;


import api.common.error.ErrorCode;
import api.common.exception.ApiException;
import db.test.TestEntity;
import db.test.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public TestEntity getOneWithThrow() {
        return testRepository.findFirstByOrderByCreatedAtDesc()
            .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "Test Entity Null"));
    }
}
