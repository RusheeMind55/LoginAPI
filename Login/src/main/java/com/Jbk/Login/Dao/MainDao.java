package com.Jbk.Login.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Jbk.Login.entity.User;
@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
	
	
	public User loginUser(User user) {
		
		Session session=null;
		Transaction tx=null;
		String strQuery="from User where username=:username and password=:password";
		User u=null;
		try {		
			 session= factory.openSession();
			 tx=session.beginTransaction();
			 
			 Query<User> query= session.createQuery(strQuery,User.class);
			 
			 query.setParameter("username",user.getUsername());
			 query.setParameter("password", user.getPassword());
			 
			 u= query.uniqueResult();
			 
			 tx.commit();
			 
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return u;
		
	}

}
