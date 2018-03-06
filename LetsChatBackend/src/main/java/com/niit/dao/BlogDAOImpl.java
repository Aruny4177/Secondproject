package com.niit.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}	
		}

	@Override
	public boolean updateBlog(Blog blog) {
		
		try
		{
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public Blog getBlog(int blogId) {
		try
		{
			Session session=sessionFactory.openSession();
			Blog blog=session.get(Blog.class, blogId);
			session.close();
			return blog;
		}
		catch(Exception e){
		return null;}
	}

	@Override
	public boolean approveBlog(Blog blog) {
		try
		{
		 blog.setStatus("A");
		 sessionFactory.getCurrentSession().update(blog);
		 return true;
		}
		catch(Exception e)
		{
		
		
		return false;
		}
	}

	@Override
	public boolean rejectBlog(Blog blog) {
		try
		{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public List<Blog> listBlog(String username) {
		
		return null;
	}

	
}
