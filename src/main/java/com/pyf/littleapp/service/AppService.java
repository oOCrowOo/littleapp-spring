package com.pyf.littleapp.service;

import com.pyf.littleapp.model.UserInfo;

public interface AppService {
	UserInfo findByUserPass(String username, String password);
	int insert(String username, String password, String phone, Boolean manager);
}
