package com.niit.dao;

import java.util.List;

import com.niit.Model.Forum;

public interface ForumDAO 
{
	public boolean saveorUpdateForum(Forum forum);
	public Forum getForumById(int forumId);
	public List<Forum> getAllForums();
	public boolean delete(int forumId);
}
