package com.Jbk.Login.Service;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jbk.Login.Dao.MainDao;
import com.Jbk.Login.entity.User;

@Service
public class MainService {
	
	@Autowired
	MainDao dao;


	public HashMap loginUser(User
			user) {
		
		User e= dao.loginUser(user);
		HashMap map=new HashMap();
		if(Objects.isNull(e)) {
			map.put("msg","Invalid User");
			map.put("user", e);
		}else {
			map.put("msg","Valid User");
			map.put("user", e);
	}
		
		
		return map;
	}

}	
	