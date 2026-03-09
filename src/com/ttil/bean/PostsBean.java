package com.ttil.bean;

import java.io.Serializable;

public class PostsBean  implements Serializable{

	private static final long serialVersionUID = 5152543486844793358L;
	private int post_id=0;
	private int org_id=0;
	private String notification_number=null;
	private String age_caluclate_date=null;
	private String post_start_date=null;
	private String post_end_date=null;
	private String org_name=null;
	private String post_name=null;
	private int max_age=0;
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public String getNotification_number() {
		return notification_number;
	}
	public void setNotification_number(String notification_number) {
		this.notification_number = notification_number;
	}
	public String getPost_start_date() {
		return post_start_date;
	}
	public void setPost_start_date(String post_start_date) {
		this.post_start_date = post_start_date;
	}
	public String getPost_end_date() {
		return post_end_date;
	}
	public void setPost_end_date(String post_end_date) {
		this.post_end_date = post_end_date;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public int getMax_age() {
		return max_age;
	}
	public void setMax_age(int max_age) {
		this.max_age = max_age;
	}
	public String getAge_caluclate_date() {
		return age_caluclate_date;
	}
	public void setAge_caluclate_date(String age_caluclate_date) {
		this.age_caluclate_date = age_caluclate_date;
	}
	
}
