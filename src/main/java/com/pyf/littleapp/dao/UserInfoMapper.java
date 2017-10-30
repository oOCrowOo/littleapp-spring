package com.pyf.littleapp.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pyf.littleapp.model.UserInfo;

@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    //int insert(UserInfo record);
    
    @Insert("INSERT INTO UserInfo(username,pwd,phone,manager) VALUES(#{username},#{pwd},#{phone},#{manager})")
    int insert(@Param("username") String username, @Param("pwd") String pwd, @Param("phone") String phone, @Param("manager") Boolean manager);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    @Results({
    	 	@Result(property = "id", column = "id"),
        @Result(property = "username", column = "username"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "manager", column = "manager"),
    })
    @Select("SELECT id,username,phone,manager FROM UserInfo WHERE username=#{username} AND pwd=#{pwd}") 
    UserInfo selectByNamePass(@Param("username") String username, @Param("pwd") String pwd);
}