package com.bethany.dao;

import com.bethany.model.Tarticle;

public interface TarticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Tarticle record);

    int insertSelective(Tarticle record);

    Tarticle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Tarticle record);

    int updateByPrimaryKeyWithBLOBs(Tarticle record);

    int updateByPrimaryKey(Tarticle record);
}