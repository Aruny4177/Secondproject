package com.niit.dao;

import java.util.List;

import com.niit.Model.User;

public interface UserDAO 
{
	public boolean saveOrUpdateUser( User  user);
	public  User  getUserById(int  userId);
	public List< User > getAllUsers();
	public boolean delete(int userId);

}
