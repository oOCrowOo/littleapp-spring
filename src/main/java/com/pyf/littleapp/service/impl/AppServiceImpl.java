package com.pyf.littleapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyf.littleapp.dao.UserInfoMapper;
import com.pyf.littleapp.model.UserInfo;
import com.pyf.littleapp.service.AppService;

@Service
public class AppServiceImpl implements AppService{

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfo findByUserPass(String username, String pwd) {
		
		return userInfoMapper.selectByNamePass(username,pwd);
	}

	@Override
	public int insert(String username, String password, String phone, Boolean manager) {
		
		return userInfoMapper.insert(username, password, phone, manager);
	}

}
