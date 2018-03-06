package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	/*public public ForumDAOImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory=sessionFactory;
	}*/
	
	@Override
	public boolean saveorUpdateForum(Forum forum) {
		Session session=sessionFactory.openSession();
		try
		{
			session.saveOrUpdate(forum);
			session.flush();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return false;
		
	}

	@Override
	public Forum getForumById(int forumId) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Forum.class, forumId);
	}

	@Override
	public List<Forum> getAllForums() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Forum");
		List<Forum> forums=query.list();
		
		return forums;
	}

	@Override
	public boolean delete(int forumId) {
		try
		{
			Forum forum=getForumById(forumId);
			sessionFactory.getCurrentSession().delete(forum);
			sessionFactory.getCurrentSession().flush();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

}
