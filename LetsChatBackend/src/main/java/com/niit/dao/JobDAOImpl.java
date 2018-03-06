package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Job;

@Repository("jobDAO")
@Transactional

public class JobDAOImpl implements JobDAO   
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Job getJobById(int jobId) {
	
		Session session = sessionFactory.openSession();
		return (Job) session.get(Job.class, jobId);


	}

	@Override
	public List<Job> getAllJobs() {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Job");
		List<Job> jobs = query.list();
		return jobs;

		

	}

	@Override
	public boolean delete(int jobId) {

		try {

			Job job = getJobById(jobId);
			sessionFactory.getCurrentSession().delete(job);
			sessionFactory.getCurrentSession().flush();

			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	
		
		return false;
	}

	@Override
	public boolean saveOrUpdateJob(Job job) {
		Session session = sessionFactory.openSession();
		try 
		{
			session.saveOrUpdate(job);
			session.flush();
			return true;
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	
		return false;
	}
	
	

}
