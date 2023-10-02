package api.test.controller;

import api.test.model.TestResponse;
import db.test.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TestRepository testRepository;
    @GetMapping("/me")
    public TestResponse me() throws Exception {

        var testEntity = testRepository.findById(1L).orElseThrow(()->new Exception());
        return TestResponse.builder()
                .id(testEntity.getId())
                .memo(testEntity.getMemo())
                .amount(testEntity.getAmount())
                .modifiedAt(testEntity.getModifiedAt())
                .createdAt(testEntity.getCreatedAt())
                .build();
    }
}
