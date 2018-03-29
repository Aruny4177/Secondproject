package com.niit.CollaborationProjectBackEnd;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.UserDetails;

public class UserTest {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize(){
		System.out.println("Initializing Test Case");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		userDAO=(UserDAO)context.getBean("userDAO");
		System.out.println("User DAO : "+userDAO);
	}

	@Test
	@Ignore
	public void registerUserTest(){
		
		UserDetails user=new UserDetails();
		user.setLoginName("aruny4177");
		user.setFirstName("arun");
		user.setLastName("yadav");
		user.setEmail("aruny4177@gmail.com");
		user.setMobileNumber("8400929483");
		user.setOnlineStatus("N");
		user.setPassword("niit2123");
		user.setRole("Role_User");
		assertTrue("Problem in Inserting User",userDAO.registerUser(user));
	}
	
	
	@Test
	@Ignore
	public void testUpdateOnlineStatus(){
		UserDetails userDetail=userDAO.getUser("aviagg");
		assertTrue("Problem in Updating",userDAO.updateOnlineStatus("N", userDetail.getLoginName()));
	}
	
	
	@Test
	@Ignore
	public void checkLoginTest(){
		UserDetails obj=new UserDetails();
		obj.setLoginName("aruny4177");
		obj.setPassword("niit@123");
		assertTrue("Check User Fail",userDAO.checkLogin(obj));
	}

	@Test
	@Ignore
	public void listUsersTest(){
		List<UserDetails> users=userDAO.getUserDetails();
		assertTrue("Users Doesnt exist",users.size()==0);
	}
	

	@Test
	@Ignore
	public void getUserTest(){
		assertNotNull("Succesfully fetched a single User from the table",userDAO.getUser("divyagarg"));
		
	}
	
	@Test
	@Ignore
	public void testUpdateUser(){
		UserDetails user=userDAO.getUser("arun");
		System.out.println(user);
		user.setEmail("aruny4177@gmail.com");
		
		assertEquals("Succesfully updated the loginname of the User", true,userDAO.updateUser(user));
	}
	
	
	@Test
	@Ignore
	public void testDeleteUser(){
		UserDetails User=userDAO.getUser("arun");
		assertEquals("User Deleted Succesfully", true,userDAO.deleteUser(User));
	}
	
}



