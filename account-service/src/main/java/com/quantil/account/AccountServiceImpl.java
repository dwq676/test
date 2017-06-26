package com.quantil.account;

import com.quantil.account.role.Account2RoleModel;
import com.quantil.account.role.RoleModel;
import com.zoe.snow.Global;
import com.zoe.snow.auth.AccountViewModel;
import com.zoe.snow.auth.NoNeedVerify;
import com.zoe.snow.auth.Token;
import com.zoe.snow.auth.service.BaseUserService;
import com.zoe.snow.bean.BeanFactory;
import com.zoe.snow.cache.Cache;
import com.zoe.snow.conf.AuthenticationConf;
import com.zoe.snow.crud.CrudService;
import com.zoe.snow.crud.Result;
import com.zoe.snow.crud.service.proxy.QueryProxy;
import com.zoe.snow.message.Message;
import com.zoe.snow.model.support.user.BaseUserModel;
import com.zoe.snow.util.Security;
import com.zoe.snow.util.Validator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * AccountServiceImpl
 *
 * @author <a href="mailto:dwq676@126.com">daiwenqing</a>
 * @date 2017/4/27
 */
@Service("account.service")
public class AccountServiceImpl implements BaseUserService, AccountService {
    @Autowired
    private CrudService crudService;
    @Autowired
    private AuthenticationConf conf;

    @Override
    public Result getUser(String userId, String token) {
        return Result.reply(() -> {
            return crudService.query().from(AccountModel.class).list();
        });
    }

    @Override
    @NoNeedVerify
    @Transactional
    public Result login(String appId, String ip, AccountViewModel accountViewModel) {
        return Result.reply(() -> {
            if (accountViewModel == null)
                return Message.LoginError;
            if (Validator.isEmpty(accountViewModel.getUsername()) || Validator.isEmpty(accountViewModel.getPassword()))
                return Message.LoginError;
            try {
                Subject subject = SecurityUtils.getSubject();
                subject.getSession().setAttribute(Global.DOMAIN, appId);
                subject.login(new UsernamePasswordToken(accountViewModel.getUsername(),
                        accountViewModel.getPassword(), accountViewModel.getRememberMe()));
                if (subject.isAuthenticated()) {
                    AccountModel user = (AccountModel) subject.getSession().getAttribute(Security.md5(appId + accountViewModel.getUsername()));
                    //subject.getSession().
                    if (user == null)
                        return Message.LoginError;
                    user.setLastLoginIp(ip);
                    user.setLastLoginAt(new Date());
                    crudService.save(user);
                    return (Token)Cache.getInstance().get(user.getToken());
                } else {
                    return Message.LoginError;
                }
            } catch (ExcessiveAttemptsException | LockedAccountException e) {
                // 多次重复尝试错误，账号被锁定
                return Message.LoginLock;
            } catch (AuthenticationException e) {
                //result.setResult(null, Message.LoginError);
                return Message.LoginError;
            }
        });

    }

    @Override
    @NoNeedVerify
    public Result logout(String token) {
        return Result.reply(() -> {
            Subject subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated())
                subject.logout();
            Cache.getInstance().remove(token);
            return Message.Success;
        });
    }

    @Override
    @NoNeedVerify
    public Result<Token> verify(String token) {
        /*return Result.reply(() -> {
            if (!Validator.isEmpty(Cache.getInstance().get(token)))
                return Cache.getInstance().get(token);
            return Message.UnAuthorized;
        });*/

        Result result = BeanFactory.getBean(Result.class);
        if (!Validator.isEmpty(Cache.getInstance().get(token)))
            result.setResult(Cache.getInstance().get(token), true, Message.Success);
        else
            result.setResult(null, false, Message.UnAuthorized);
        return result;
    }


    @Override
    @NoNeedVerify
    public List<BaseUserModel> findByUsername(String username, String... domain) {
        if (Validator.isEmpty(username))
            return null;
        QueryProxy queryProxy = crudService.query().from(AccountModel.class)
                .setExcludeDomain(true)
                .where("username", username);
        if (domain.length > 0) {
            if (!Validator.isEmpty(domain[0]))
                queryProxy.where("appId", domain[0]);
        }

        return queryProxy.list();
    }

    @Override
    @NoNeedVerify
    public BaseUserModel findByPhone(String phone) {
        return null;
    }

    @Override
    @NoNeedVerify
    public BaseUserModel findByUserId(String id) {
        return null;
    }

    @Override
    @NoNeedVerify
    public BaseUserModel findByIdCard(String idCard) {
        return null;
    }

    @Override
    @NoNeedVerify
    public Set<String> findRoles(String username) {
        return null;
    }
}
