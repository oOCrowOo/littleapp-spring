package com.pyf.littleapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pyf.littleapp.model.UserInfo;
import com.pyf.littleapp.service.AppService;

@RestController
@EnableAutoConfiguration 
public class Controller {
	
	@Autowired
	private AppService appService;
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping(value="/login",method= RequestMethod.GET)
    public UserInfo findNamePass(@RequestParam("username") String username, @RequestParam("pwd") String pwd) {
		return appService.findByUserPass(username, pwd);
    }
	
	@RequestMapping(value="/register",method= RequestMethod.POST)
	public int insert(@RequestParam("username") String username, @RequestParam("pwd") String pwd, @RequestParam("phone") String phone,  @RequestParam("manager") Boolean manager) {
		if(appService.findByUserPass(username, pwd) != null) return 0;
		else return appService.insert(username,pwd,phone,manager);
	}
}
