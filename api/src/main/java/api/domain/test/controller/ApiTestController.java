package api.domain.test.controller;

import api.common.annotation.UserSession;
import api.common.api.Api;
import api.domain.test.business.TestBusiness;
import api.domain.test.model.Test;
import api.domain.test.model.TestResponse;
import db.test.TestRepository;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Slf4j
public class ApiTestController {

    private final TestBusiness testBusiness;


//    @GetMapping("/me/{id}")
//    public Api<TestResponse> me(@PathVariable(name = "id") Long id) throws Exception {
//        return Api.OK(testBusiness.me(id));
//    }

    @GetMapping("/me/{id}")
    public Api<TestResponse> me(
            @PathVariable(name = "id") Long id,
            @Parameter(hidden = true)  // swagger ui에서는 hidden 처리된다.
            @UserSession Test test   // user session resolver에 의해 세션 정보가 주입된다., 상기 PathVariable 없어도 body에 id가 있으면 주입된다.
    ) throws Exception {
        return Api.OK(testBusiness.me(test.getId()));
    }

}
