package api.domain.token.converter;

import api.common.annotation.Converter;
import api.common.error.ErrorCode;
import api.common.exception.ApiException;
import api.domain.token.model.TokenResponse;
import api.domain.token.model.TokenDto;
import lombok.RequiredArgsConstructor;


import java.util.Objects;

@RequiredArgsConstructor
@Converter
public class TokenConverter {

    public TokenResponse toResponse(
        TokenDto accessToken,
        TokenDto refreshToken
    ){
        Objects.requireNonNull(accessToken, ()->{throw new ApiException(ErrorCode.NULL_POINT);});
        Objects.requireNonNull(refreshToken, ()->{throw new ApiException(ErrorCode.NULL_POINT);});

        return TokenResponse.builder()
            .accessToken(accessToken.getToken())
            .accessTokenExpiredAt(accessToken.getExpiredAt())
            .refreshToken(refreshToken.getToken())
            .refreshTokenExpiredAt(refreshToken.getExpiredAt())
            .build();
    }
}
