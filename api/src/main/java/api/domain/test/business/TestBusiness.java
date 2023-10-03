package api.domain.test.business;

import api.common.annotation.Business;
import api.domain.test.converter.TestConverter;
import api.domain.test.model.TestResponse;
import api.domain.test.service.TestService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Business
public class TestBusiness {

    private final TestService testService;
    private final TestConverter testConverter;
    public TestResponse one() {
        var testEntity  =  testService.getOneWithThrow();
        var testResponse =  testConverter.toResponse(testEntity);
        return testResponse;
    }

}
