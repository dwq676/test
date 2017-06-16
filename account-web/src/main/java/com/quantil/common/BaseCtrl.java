package com.quantil.common;

import com.zoe.snow.context.request.Request;
import com.zoe.snow.context.response.Response;
import com.zoe.snow.context.session.Session;
import com.zoe.snow.crud.Result;
import com.zoe.snow.util.Converter;
import com.zoe.snow.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BaseCtrl
 *
 * @author <a href="mailto:dwq676@126.com">daiwenqing</a>
 * @date 2017/5/31
 */
public class BaseCtrl {
    @Autowired
    protected Request request;
    @Autowired
    protected Session session;
    @Autowired
    protected Response response;

    protected String getToken() {
        //String token = request.getHeader(Constants.AUTHORIZATION);
        //return request.getHeader();;

        return request.getHeader("token");
    }

    protected Object reply(Result result) {
        if (Validator.isNumeric(result.getCode()))
            response.setStatusCode(Converter.toInt(result.getCode()));
        return result;
    }
}
