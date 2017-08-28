package com.bethany.dao;

import com.bethany.model.Tgroup;
import org.apache.ibatis.annotations.Param;

public interface TgroupMapper {
    int deleteByPrimaryKey(@Param("group") String group, @Param("groupitem") String groupitem);

    int insert(Tgroup record);

    int insertSelective(Tgroup record);

    Tgroup selectByPrimaryKey(@Param("group") String group, @Param("groupitem") String groupitem);

    int updateByPrimaryKeySelective(Tgroup record);

    int updateByPrimaryKey(Tgroup record);
}