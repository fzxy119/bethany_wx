package com.bethany.service;

import com.bethany.vo.ResMessage;

/**
 * Created by chenxiao on 2017/7/30at 18:06
 */
public interface TuserService {

    public ResMessage login(String phone,String pwd);

}
