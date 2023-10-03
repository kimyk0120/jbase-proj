package api.domain.test.controller;

import api.common.api.Api;
import api.domain.test.business.TestBusiness;
import api.domain.test.controller.model.LoginRequest;
import api.domain.test.model.TestResponse;
import api.domain.token.model.TokenResponse;
import db.test.TestRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/open-api/test")
@RequiredArgsConstructor
@Slf4j
public class OpenApiTestController {

    private final TestBusiness testBusiness;


    // token test
    @PostMapping("/login")
    public Api<TokenResponse> login(@Valid @RequestBody Api<LoginRequest> loginRequest) {

        var response = testBusiness.login(loginRequest.getBody());
        return Api.OK(response);
    }
}
