package com.quantil.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * IndexCtrl
 *
 * @author <a href="mailto:wenqing.dai@quantil.com">daiwenqing</a>
 * @date 2017/3/27
 */
@Controller
@RestController
@RequestMapping(value = "/")
@Api(hidden = true)
public class IndexCtrl extends BaseCtrl {
    @RequestMapping("/docs")
    @ApiOperation(value = "", hidden = true)
    public ModelAndView index() {
        session.put("path", "../");
        session.put("time", System.currentTimeMillis());
        return new ModelAndView("index");
    }

}
