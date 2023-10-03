package api.domain.test.business;

import api.common.annotation.Business;
import api.domain.test.controller.model.LoginRequest;
import api.domain.test.converter.TestConverter;
import api.domain.test.model.TestResponse;
import api.domain.test.service.TestService;
import api.domain.token.business.TokenBusiness;
import api.domain.token.model.TokenResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Business
public class TestBusiness {

    private final TestService testService;
    private final TestConverter testConverter;
    private final TokenBusiness tokenBusiness;

    public TestResponse one() {
        var testEntity  =  testService.getOneWithThrow();
        var testResponse =  testConverter.toResponse(testEntity);
        return testResponse;
    }

    /**
     * 1. id (ex : email, password) 를 가지고 사용자 체크
     * 2. entity 확인
     * 3. token 생성
     * 4. token response
     */
    public TokenResponse login(LoginRequest request) {
        var userEntity = testService.getById(request.getId());
        var tokenResponse = tokenBusiness.issueToken(userEntity);
        return tokenResponse;
    }

    public TestResponse me(Long id) {
        var testEntity = testService.getById(id);
        var testResponse = testConverter.toResponse(testEntity);
        return testResponse;
    }
}
