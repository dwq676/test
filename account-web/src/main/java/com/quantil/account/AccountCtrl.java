package com.quantil.account;

import com.quantil.common.BaseCtrl;
import com.quantil.common.Notes;
import com.zoe.snow.auth.AccountViewModel;
import com.zoe.snow.auth.Token;
import com.zoe.snow.bean.BeanFactory;
import com.zoe.snow.cache.Cache;
import com.zoe.snow.crud.Result;
import com.zoe.snow.model.support.user.BaseUserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * AccountCtrl
 *
 * @author <a href="mailto:wenqing.dai@quantil.com">daiwenqing</a>
 * @date 2017/4/15
 */
@Controller("account.user.ctrl")
@RequestMapping("/api/0.1/accounts")
@RestController
@Api(value = "accounts", description = " ", tags = {"accounts"}, hidden = true)
public class AccountCtrl extends BaseCtrl {
    @Autowired
    private BaseUserModel baseUserModelSupport;
    @Autowired
    private AccountService accountService;

    /*@RequestMapping(value = "/v/login", method = RequestMethod.POST)
    @ApiOperation(value = "login", hidden = true)
    public ModelAndView loginTo(String username, String password, String appId) {
        ModelAndView modelAndView = null;
        AccountViewModel accountViewModel = new AccountViewModel();
        accountViewModel.setAppid(appId);
        accountViewModel.setPassword(password);
        accountViewModel.setUsername(username);
        Object object = login(accountViewModel);
        Result<Token> result = (Result<Token>) object;
        if (result.isSuccess()) {
            modelAndView = new ModelAndView("index");
            //String token = Generator.uuid();
            session.put("token", result.getData().getToken());
            session.put("is_authenticated", true);
            session.put("username", username);
            session.put(result.getData().getToken(), baseUserModelSupport);
            session.put("time", System.currentTimeMillis());
            session.put("CSRFToken", Base64Utils.encode((Generator.uuid() + System.currentTimeMillis()).getBytes()));
            session.put("path", "../../");
        } else {
            modelAndView = new ModelAndView("redirect:../auth.html");
        }
        return modelAndView;
    }*/


    /*@ApiParam(name = "appid", value = "app id", required = true) @RequestParam String appid,
                        @ApiParam(name = "username", value = "", required = true) @RequestParam String username,
                        @ApiParam(name = "password", value = "", required = true) @RequestParam String password*/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = Notes.RESPONSE_HEAD + Description.LOGIN_RESPONSE)
    public Object login(@ApiParam(name = "account", value = "json", required = true)
                        @RequestBody AccountViewModel account) {
        AccountModel accountModel = BeanFactory.getBean(AccountModel.class);
        if (account == null)
            account = new AccountViewModel();
        Result<Token> tokenResult = accountService.login(account.getAppid(), request.getIp(), account);
        if (tokenResult.getData() != null)
            response.addHeader("token", tokenResult.getData().getToken());
        return reply(tokenResult);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = Notes.RESPONSE_HEAD + Description.LOGOUT_RESPONSE)
    public Object logout(@ApiParam(name = "token", value = "token", required = true) @RequestBody String token) {
        return reply(accountService.logout(token));
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = Notes.RESPONSE_HEAD + Description.VERIFY_RESPONSE)
    public Object verify(@ApiParam(name = "token", value = "token", required = true) @RequestBody String token) {
        return reply(accountService.verify(token));
    }

    @RequestMapping(value = "/v/logout")
    @ApiOperation(value = "logout", hidden = true)
    public ModelAndView logoutTo() {
        if (session.get("is_authenticated")) {
            //session.put("token", "");
            session.put("is_authenticated", false);
            session.put("path", "");
            session.remove("username");
            session.remove(session.get("token"));
            session.remove("CSRFToken");
            session.remove("time");
            Cache.getInstance().remove(session.get("token"));
            session.remove("token");
            logout(getToken());
        }
        return new ModelAndView("redirect:../auth.html");
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "test", hidden = true)
    public Object test(@PathVariable("id") String id) {
        return reply(accountService.getUser(id, getToken()));
    }

}
