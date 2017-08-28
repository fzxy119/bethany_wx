package com.bethany.service.impl;

import com.bethany.service.TuserService;
import com.bethany.vo.ResMessage;
import org.springframework.stereotype.Service;

/**
 * Created by chenxiao on 2017/7/30at 18:07
 */
@Service
public class TuserServiceImpl implements TuserService {

    @Override
    public ResMessage login(String phone, String pwd) {
        System.out.println("phoe:"+phone+",pwd:"+pwd);
        if(!"15067139169".equals(phone)){
            return ResMessage.fail("账号密码错误");
        }
        return ResMessage.success();
    }
}
