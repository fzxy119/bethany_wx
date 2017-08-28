package com.bethany.dao;

import com.bethany.model.TartLabel;
import org.apache.ibatis.annotations.Param;

public interface TartLabelMapper {
    int deleteByPrimaryKey(@Param("articleId") String articleId, @Param("labelId") String labelId);

    int insert(TartLabel record);

    int insertSelective(TartLabel record);

    TartLabel selectByPrimaryKey(@Param("articleId") String articleId, @Param("labelId") String labelId);

    int updateByPrimaryKeySelective(TartLabel record);

    int updateByPrimaryKey(TartLabel record);
}