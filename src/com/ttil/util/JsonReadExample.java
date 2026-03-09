package com.ttil.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ttil.bean.OrganizationBean;
import com.ttil.bean.PostsBean;

public class JsonReadExample {

	public static LinkedHashMap<Integer,OrganizationBean> readOrganizationAndPosts(String path)
	{
		JSONParser parser = new JSONParser();
		LinkedHashMap<Integer,OrganizationBean> hashmp=null;
		try {
			hashmp=new LinkedHashMap<Integer,OrganizationBean>();
			Object obj = parser.parse(new FileReader(path));
			JSONObject jsonObject = (JSONObject) obj;
			// loop array
			JSONArray organizationsArray = (JSONArray) jsonObject.get("organizations");
			Iterator<JSONObject> iterator = organizationsArray.iterator();
			while (iterator.hasNext()) {
				OrganizationBean organizationBean=null;
				JSONObject organizationsJson = (JSONObject) iterator.next();

				boolean status = (Boolean) organizationsJson.get("status");
				long org_id = (Long) organizationsJson.get("org_id");
				if(status)
				{
					String org_name = (String) organizationsJson.get("org_name");
					organizationBean=new OrganizationBean();
					organizationBean.setOrg_id((int)org_id);
					organizationBean.setOrg_name(org_name);
					organizationBean.setStatus(status);
					// loop array
					JSONArray postssArray = (JSONArray) organizationsJson.get("posts");
					Iterator<JSONObject> postsIterator = postssArray.iterator();
					Vector<PostsBean> postsVector =new Vector<PostsBean>();
					while (postsIterator.hasNext()) {
						JSONObject postsJson = (JSONObject) postsIterator.next();

						boolean post_status = (Boolean) postsJson.get("post_status");
						if(post_status)
						{
							PostsBean postsBean=new PostsBean();
							long post_id = (Long) postsJson.get("post_id");
							long org_id1 = (Long) postsJson.get("org_id");
							long max_age = (Long) postsJson.get("max_age");
							String post_name = (String) postsJson.get("post_name");
							String notification_number = (String) postsJson.get("notification_number");
							String post_start_date = (String) postsJson.get("post_start_date");
							String post_end_date = (String) postsJson.get("post_end_date");
							String age_caluclate_date = (String) postsJson.get("age_caluclate_date");
							postsBean.setPost_id((int)post_id);
							postsBean.setOrg_id((int)org_id1);
							postsBean.setMax_age((int)max_age);
							postsBean.setPost_name(post_name);
							postsBean.setNotification_number(notification_number);
							postsBean.setPost_start_date(post_start_date);
							postsBean.setPost_end_date(post_end_date);
							postsBean.setOrg_name(org_name);
							postsBean.setAge_caluclate_date(age_caluclate_date);
							postsVector.add(postsBean);
						}// end-if post_status ==true
					} //posts array while loop end 
					organizationBean.setPosts(postsVector);
				}// end-if org status ==true

				hashmp.put((int)org_id, organizationBean);
			}// org array while loop end
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return hashmp;
	}

	public static PostsBean getPostDetails(String path,String selected_post_id)
	{
		PostsBean postsBean=null;
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(path));
			JSONObject jsonObject = (JSONObject) obj;
			// loop array
			JSONArray organizationsArray = (JSONArray) jsonObject.get("organizations");
			Iterator<JSONObject> iterator = organizationsArray.iterator();
			while (iterator.hasNext()) {
				OrganizationBean organizationBean=null;
				JSONObject organizationsJson = (JSONObject) iterator.next();

				boolean status = (Boolean) organizationsJson.get("status");
				long org_id = (Long) organizationsJson.get("org_id");
				if(status)
				{
					String org_name = (String) organizationsJson.get("org_name");
					organizationBean=new OrganizationBean();
					organizationBean.setOrg_id((int)org_id);
					organizationBean.setOrg_name(org_name);
					organizationBean.setStatus(status);
					// loop array
					JSONArray postssArray = (JSONArray) organizationsJson.get("posts");
					Iterator<JSONObject> postsIterator = postssArray.iterator();
					while (postsIterator.hasNext()) {
						JSONObject postsJson = (JSONObject) postsIterator.next();

						boolean post_status = (Boolean) postsJson.get("post_status");
						if(post_status)
						{
							long post_id = (Long) postsJson.get("post_id");
							if(selected_post_id.equalsIgnoreCase(post_id+"")){
								postsBean=new PostsBean();
								long org_id1 = (Long) postsJson.get("org_id");
								long max_age = (Long) postsJson.get("max_age");
								String post_name = (String) postsJson.get("post_name");
								String notification_number = (String) postsJson.get("notification_number");
								String post_start_date = (String) postsJson.get("post_start_date");
								String post_end_date = (String) postsJson.get("post_end_date");
								String age_caluclate_date = (String) postsJson.get("age_caluclate_date");
								postsBean.setPost_id((int)post_id);
								postsBean.setOrg_id((int)org_id1);
								postsBean.setMax_age((int)max_age);
								postsBean.setPost_name(post_name);
								postsBean.setNotification_number(notification_number);
								postsBean.setPost_start_date(post_start_date);
								postsBean.setPost_end_date(post_end_date);
								postsBean.setOrg_name(org_name);
								postsBean.setAge_caluclate_date(age_caluclate_date);
								return postsBean;
							}
						}// end-if post_status ==true
					} //posts array while loop end 
				}// end-if org status ==true

			}// org array while loop end
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return postsBean;
	}

	public static PostsBean getPostDetails()
	{
		PostsBean postsBean=null;
		try {
			postsBean=new PostsBean();
			postsBean.setPost_id(101);
			postsBean.setOrg_id(1);
			postsBean.setPost_name("Pay band - 1 (Rs 5,200 - 20,200) with grade pay of Rs.1,800/- in Southern Railway & ICF");
			postsBean.setNotification_number("RRC 02 / 2013 dated 21-09-2013");
			postsBean.setPost_start_date("21-09-2013");
			postsBean.setPost_end_date("21-10-2013 at 17:00 hrs");
			postsBean.setOrg_name("RAILWAY RECRUITMENT CELL - SOUTHERN RAILWAY, CHENNAI");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postsBean;
	}
}
