package api.domain.test.controller;

import api.common.api.Api;
import api.domain.test.business.TestBusiness;
import api.domain.test.model.TestResponse;
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
public class ApiTestController {

    private final TestBusiness testBusiness;


    @GetMapping("/one")
    public Api<TestResponse> one() throws Exception {
        return Api.OK(testBusiness.one());
    }
}
