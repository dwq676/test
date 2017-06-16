package com.quantil.account;

import com.quantil.common.AbstractTestNGTest;
import com.zoe.snow.auth.AccountViewModel;
import com.zoe.snow.auth.Token;
import com.zoe.snow.conf.AuthenticationConf;
import org.apache.shiro.mgt.SecurityManager;
import com.zoe.snow.crud.CrudService;
import com.zoe.snow.crud.Result;
import com.zoe.snow.model.support.user.BaseUserModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.ServletConfig;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

/**
 * AccountServiceImplTest
 *
 * @author <a href="mailto:dwq676@126.com">daiwenqing</a>
 * @date 2017/6/15
 */

@WebAppConfiguration("/src/test/java")
public class AccountServiceImplTest extends AbstractTestNGTest {

    @Autowired
    private CrudService crudService;

    @Autowired
    private AccountService accountService;

    @Test
    public void testLogin() {
        String appid = "rdc";
        String username = "dwq", password = "dwq";
        boolean rememberMe = false;
        AccountViewModel accountViewModel = new AccountViewModel();
        accountViewModel.setRememberMe(rememberMe);
        accountViewModel.setAppid(appid);
        accountViewModel.setPassword(password);
        accountViewModel.setUsername(username);

        /*Factory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = (SecurityManager)factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);*/

        String ip = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        } catch (UnknownHostException e) {

        }


        Result<Token> result = accountService.login(appid, ip, accountViewModel);
        Assert.assertNotNull(result);

        Assert.assertNotNull(crudService);
    }


    /*@Mock

    @Mock
    AuthenticationConf conf;
    @InjectMocks
    AccountServiceImpl accountServiceImpl;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUser() {
        Result result = accountServiceImpl.getUser("userId", "token");
        //Assert.assertEquals(result, new Result(new T(), Message.Success));
    }

    @Test
    public void testLogin() {
        Result result = accountServiceImpl.login("appId", "ip", new AccountViewModel());
        //Assert.assertEquals(result, new Result(new T(), Message.Success));
    }

    @Test
    public void testLogout() {
        Result result = accountServiceImpl.logout("token");
        //Assert.assertEquals(result, new Result(new T(), Message.Success));
    }

    @Test
    public void testVerify() {
        Result<Token> result = accountServiceImpl.verify("token");
        //Assert.assertEquals(result, new Result<Token>(new T(), Message.Success));
    }

    @Test
    public void testFindByUsername() {
        List<BaseUserModel> result = accountServiceImpl.findByUsername("username", "domain");
        Assert.assertEquals(result, Arrays.<BaseUserModel>asList(null));
    }

    @Test
    public void testFindByPhone() {
        BaseUserModel result = accountServiceImpl.findByPhone("phone");
        Assert.assertEquals(result, null);
    }

    @Test
    public void testFindByUserId() {
        BaseUserModel result = accountServiceImpl.findByUserId("id");
        Assert.assertEquals(result, null);
    }

    @Test
    public void testFindByIdCard() {
        BaseUserModel result = accountServiceImpl.findByIdCard("idCard");
        Assert.assertEquals(result, null);
    }

    @Test
    public void testFindRoles() {
        Set<String> result = accountServiceImpl.findRoles("username");
        Assert.assertEquals(result, new HashSet<String>(Arrays.asList("String")));
    }*/
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme