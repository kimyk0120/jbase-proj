package api.domain.token.service;

import api.common.error.ErrorCode;
import api.common.exception.ApiException;
import api.domain.token.ifs.TokenHelperIfs;
import api.domain.token.model.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * token 에 대한 도메인 로직
 */
@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenHelperIfs tokenHelperIfs;

    public TokenDto issueAccessToken(Long id){
        var data = new HashMap<String, Object>();
        data.put("id", id);
        return tokenHelperIfs.issueAccessToken(data);
    }

    public TokenDto issueRefreshToken(Long id){
        var data = new HashMap<String, Object>();
        data.put("id", id);
        return tokenHelperIfs.issueRefreshToken(data);
    }

    public Long validationToken(String token){
        var map = tokenHelperIfs.validationTokenWithThrow(token);

        var id = map.get("id");
        Objects.requireNonNull(id, ()->{throw new ApiException(ErrorCode.NULL_POINT);});

        return Long.parseLong(id.toString());
    }

}
