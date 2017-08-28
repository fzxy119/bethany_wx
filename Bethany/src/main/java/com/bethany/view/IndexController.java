package com.bethany.view;


import com.bethany.service.TuserService;
import com.bethany.vo.ResMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chenxiao on 2017/7/24at 12:49
 */
@Controller
public class IndexController {


    @Autowired
    private TuserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ResMessage login(HttpServletRequest req,HttpServletResponse rep){
        return userService.login(req.getParameter("phone"),req.getParameter("pwd"));
    }


}
