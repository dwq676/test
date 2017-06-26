package com.quantil.account;

import com.zoe.snow.auth.AccountViewModel;
import com.zoe.snow.auth.Authentication;
import com.zoe.snow.auth.Token;
import com.zoe.snow.crud.Result;

/**
 * AccountService
 *
 * @author <a href="mailto:dwq676@126.com">daiwenqing</a>
 * @date 2017/4/27
 */
public interface AccountService extends Authentication {
    Result getUser(String userId, String token);

    /**
     * 登录
     *
     * @param appId 平台
     * @return
     */
    Result login(String appId, String ip, AccountViewModel accountViewModel);

    Result logout(String token);

    Result<Token> verify(String token);
}
