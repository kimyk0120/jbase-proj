package api.domain.token.business;

import api.common.annotation.Business;
import api.common.error.ErrorCode;
import api.common.exception.ApiException;
import api.domain.token.model.TokenResponse;
import api.domain.token.converter.TokenConverter;
import api.domain.token.service.TokenService;
import db.test.TestEntity;
import lombok.RequiredArgsConstructor;


import java.util.Optional;

@RequiredArgsConstructor
@Business
public class TokenBusiness {

    private final TokenService tokenService;
    private final TokenConverter tokenConverter;

    /**
     * 1. test Id 추출
     * 2. access, refresh token 발행
     * 3. converter -> token response 변경
     */
    public TokenResponse issueToken(TestEntity testEntity){

        return Optional.ofNullable(testEntity)
            .map(it -> {
                return it.getId();
            })
            .map(id -> {
                var accessToken = tokenService.issueAccessToken(id);
                var refreshToken = tokenService.issueRefreshToken(id);
                return tokenConverter.toResponse(accessToken, refreshToken);
            })
            .orElseThrow(
                ()-> new ApiException(ErrorCode.NULL_POINT)
            );
    }

    public Long validationAccessToken(String accessToken){
        var userId = tokenService.validationToken(accessToken);
        return userId;
    }

}
