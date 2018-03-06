package com.niit.Model;

import java.util.Date;

import javax.persistence.Id;

public class Forum {

	@Id
	
	public int forumId;
	public String name;
	public String topic;
	public String content;
	public int userID;
	public Date dateofCreation;
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public Date getDateofCreation() {
		return dateofCreation;
	}
	public void setDateofCreation(Date dateofCreation) {
		this.dateofCreation = dateofCreation;
	}
	
}
