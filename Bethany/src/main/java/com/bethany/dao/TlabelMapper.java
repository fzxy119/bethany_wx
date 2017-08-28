package com.bethany.dao;

import com.bethany.model.Tlabel;

public interface TlabelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Tlabel record);

    int insertSelective(Tlabel record);

    Tlabel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Tlabel record);

    int updateByPrimaryKey(Tlabel record);
}