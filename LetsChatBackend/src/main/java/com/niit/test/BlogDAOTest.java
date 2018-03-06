package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BlogDAOTest {

	@BeforeClass
	public static void intialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	}
	
	@test
	public void  test()
	{
		fail("Not yest implemented");
	}
}
