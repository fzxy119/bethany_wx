package com.bethany.dao;

import com.bethany.model.Timg;

public interface TimgMapper {
    int deleteByPrimaryKey(String id);

    int insert(Timg record);

    int insertSelective(Timg record);

    Timg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Timg record);

    int updateByPrimaryKey(Timg record);
}