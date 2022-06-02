package com.hcy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hcy.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 16691
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-05-30 20:02:57
* @Entity com.hcy.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    
    User selectByUsername(@Param("username") String username);
    
    int insertSelective(User user);
}




