package com.Jbk.Login.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jbk.Login.Service.MainService;
import com.Jbk.Login.entity.User;
@CrossOrigin
@RequestMapping
@RestController("/api")
public class MainController {
	@Autowired
 	MainService service;
	
	
//	@PostMapping("/loginApi")
//	public HashMap checkUser(@RequestBody User user ) {
//		
//		HashMap map= service.checkUser(user);
//		return map;
//		
//	}
	
	
	@PostMapping("/loginuser")
	public HashMap loginUser(@RequestBody User user) {
		
		HashMap map= service.loginUser(user);
		return map;
		
	}
	
	
}
