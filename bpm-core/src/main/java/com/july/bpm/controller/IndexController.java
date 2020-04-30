package com.july.bpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 页面跳转控制器信息
 * @author zengxueqi
 * @program july-bpm
 * @since 2020-04-07 10:45
 **/
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/createFlow")
    public String createFlow(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/static/flow-editor/modeler.html");
        return "index";
    }

}
