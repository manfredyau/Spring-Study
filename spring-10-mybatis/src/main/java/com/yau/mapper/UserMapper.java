package com.yau.mapper;

import com.yau.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
//    @Select("select id, name, pwd as password from user_ where id = #{id}")
    User getUser(@Param("id") int id);
}
