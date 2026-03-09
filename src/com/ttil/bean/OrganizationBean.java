package com.ttil.bean;

import java.io.Serializable;
import java.util.Vector;

public class OrganizationBean  implements Serializable{

	private static final long serialVersionUID = 5152543486844793358L;
	private int org_id=0;
	private String org_name=null;
	private boolean status=false;
	private Vector<PostsBean> posts=null;
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Vector<PostsBean> getPosts() {
		return posts;
	}
	public void setPosts(Vector<PostsBean> posts) {
		this.posts = posts;
	}

	
}
