package api.resolver;

import api.common.annotation.UserSession;
import api.domain.test.model.Test;
import api.domain.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class UserSessionResolver implements HandlerMethodArgumentResolver {

    private final TestService testService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 지원하는 파라미터 체크 , 어노테이션 체크

        //1. 어노테이션이 있는지 체크
        var annotation = parameter.hasParameterAnnotation(UserSession.class);

        //2. 파라미터의 타입 체크
        var parameterType = parameter.getParameterType().equals(Test.class);

        return (annotation && parameterType);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // support parameter 에서 true 반환시 여기 실행

        // request context holder에서 찾아오기
        var requestContext = RequestContextHolder.getRequestAttributes();
        var id = requestContext.getAttribute("id", RequestAttributes.SCOPE_REQUEST);

        var testEntity = testService.getById(Long.parseLong(id.toString()));

        // 사용자 정보 셋팅
        return Test.builder()
                .id(testEntity.getId())
                .amount(testEntity.getAmount())
                .memo(testEntity.getMemo())
                .createdAt(testEntity.getCreatedAt())
                .modifiedAt(testEntity.getModifiedAt())
                .build();
    }
}
