package com.niit.test;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class BlogDAOTest {


	
	AnnotationConfigApplicationContext context;
	
	public BlogDAOTest()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		//context.refresh();
	}
	
		public static void main(String[] args)
	{	
			BlogDAOTest t = new BlogDAOTest();
	     	
	
	}
}