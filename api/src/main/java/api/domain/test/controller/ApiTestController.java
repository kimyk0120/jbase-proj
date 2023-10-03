package api.domain.test.controller;

import api.common.api.Api;
import api.domain.test.business.TestBusiness;
import api.domain.test.model.TestResponse;
import db.test.TestRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Slf4j
public class ApiTestController {

    private final TestBusiness testBusiness;


    @GetMapping("/me/{id}")
    public Api<TestResponse> me(@PathVariable(name = "id") Long id) throws Exception {
        return Api.OK(testBusiness.me(id));
    }
}
