package com.ztps.birthday.glxt.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ztps.birthday.glxt.user.entity.User;

public class TestGrep {

	ClassPathXmlApplicationContext ctx;

	@Before
	public void loadCtx() {
		
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testHibernate() {
		SessionFactory sf = (SessionFactory)ctx.getBean("sessionFactory");
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		//保存人员
		session.save(new User("admin","admin","a","1"));
		transaction.commit();
		session.close();
	}

}
