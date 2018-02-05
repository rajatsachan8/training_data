package com.mindtree.spring.controller;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mindtree.spring.DAO.DAO;
import com.mindtree.spring.model.User;

@Controller
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	String current_user=null;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String homepage(Locale locale,Model model){
		System.out.println("homepage requested");
		return "homepage";
	}
	
	ModelAndView model;
	
	@RequestMapping(value = "/home1", method = RequestMethod.POST)
	public ModelAndView home1(@RequestParam("hello") String name) {
		System.out.println("Home Page Requested, locale in home1= ");
        System.out.println(name);
       
    		model=new ModelAndView("home1");
    		model.addObject("message",name);
    	
		return model;
	}
     
	@RequestMapping(value = "/home2", method = RequestMethod.POST)
	public ModelAndView home2(@RequestParam("hello") String name) {
		System.out.println("Home Page Requested, locale in home1= ");
        System.out.println(name);
 
    		model=new ModelAndView("home2");
    		model.addObject("message",name);
    	
		return model;
	}

	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView user(@Validated User user,Model model,@RequestParam("userName") String username,@RequestParam("password") String password) throws SQLException {
		System.out.println("User Page Requested");
		
	     System.out.println(user.getUserName()+"\t"+user.getPassword());
	    	DAO dao=new DAO();
	    	Boolean check=dao.checkuser(username,password);
	    	if(check){
	    		ModelAndView model1=new ModelAndView("user_login");
	    		model1.addObject("userName", username);
	    		current_user=username;
	    		return model1;
	    	}
	    	else {
	    		ModelAndView model1=new ModelAndView("home2");
	    		model1.addObject("message", "User not found or incorrect Password");
	    		return model1;
	    	}
	 		 
	     
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ModelAndView admin(@Validated User user) {
		System.out.println("admin Page Requested");
		  model=new ModelAndView("home1");
		  model.addObject("message","Admin Wrong Username or Password");
	     System.out.println(user.getUserName()+"\t"+user.getPassword());
	     if(user.getUserName().equals("admin") && user.getPassword().equals("admin@123")){
	    	model=new ModelAndView("admin_login");
	    	 model.addObject("userName", user.getUserName());
	 		model.addObject("password", user.getPassword());
	 		return model; 
	     }
		return model;
		}
		
	@RequestMapping(value="/add_user")
	public String add_user() {

	    return "add_user";
		
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView Add_user(@RequestParam Map<String, String> model1) throws SQLException{
		
		String id=model1.get("id");
		String username=model1.get("username");
		String password=model1.get("password");
		String doj=(String)model1.get("doj");
		String email=(String)model1.get("email");
		String role=model1.get("role");
		String projectid=model1.get("projectid");
		DAO dao=new DAO();
		Boolean valid=dao.validate_user(username,email);
		Boolean valid1=dao.validate_email(email);
		if(valid && valid1){
			try {
				dao.send_data(id,username,password,doj,email,role,projectid);
			} catch (SQLException e) {
				 model=new ModelAndView("add_user");
				 model.addObject("msg1", "User ID is already in database");
					return model;
			}
			
		}
		else{
			model=new ModelAndView("add_user");
			model.addObject("msg2", "Username or email exist in the database");
			return model;
		}
		model=new ModelAndView("admin_login");
			return model;
	
	}
	
	@RequestMapping(value="/add_project")
	public String add_project() {

	    return "add_project";
		
	}
	
	@RequestMapping(value="/project",method=RequestMethod.POST)
	public ModelAndView Add_project(@RequestParam Map<String,String> model1) throws SQLException{
		String Projectid=model1.get("pid");
		String projectName=model1.get("p_name");
		String description=model1.get("description");
		String estimated_time=model1.get("estimated_time");
		DAO dao=new DAO();
		dao.send_intoProject(Projectid,projectName,description,estimated_time);
		
		model=new ModelAndView("admin_login");
		return model;
	}
	
	@RequestMapping(value="/view_all_projects",method=RequestMethod.GET)
	public ModelAndView showAllProject() throws SQLException{
		ModelAndView model=new ModelAndView("showAllproject");
		DAO dao=new DAO();
		ResultSet rs=dao.getproject();
		
		   List<Integer> projectid=new ArrayList<Integer>();
		   List<String> projectname=new ArrayList<String>();
		   List<String> projectdesc=new ArrayList<String>();
		   List<Integer> estimatedhrs=new ArrayList<Integer>();
		   
		while(rs.next()){
			System.out.println();
			projectid.add(rs.getInt("project_id"));
			projectname.add(rs.getString("project_name"));
			projectdesc.add(rs.getString("project_desc"));
		    estimatedhrs.add(rs.getInt("estimated_hrs"));
		    
		 }
		
		model.addObject("projectid",projectid);
		model.addObject("projectname",projectname);
		model.addObject("projectdesc",projectdesc);
		model.addObject("estimatedhrs",estimatedhrs);
		
		return model;
	}
	
	@RequestMapping(value="/show_all_users",method=RequestMethod.GET)
	public ModelAndView showAllUsers() throws SQLException{
		ModelAndView model=new ModelAndView("showAlluser");
		DAO dao=new DAO();
		ResultSet rs=dao.getUsers();
		
		   List<Integer>userid=new ArrayList<Integer>();
		   List<String> Username=new ArrayList<String>();
		   List<String> doj=new ArrayList<String>();
		   List<String> email=new ArrayList<String>();
		   
//		   Gson gson = new Gson();
//		   String personJson = gson.toJson(rs);
//		   System.out.println(personJson);
		while(rs.next()){
			userid.add(rs.getInt("id"));
			Username.add(rs.getString("username"));
			doj.add(rs.getString("DOJ"));
			email.add(rs.getString("email_id"));
		}
		
		model.addObject("username",Username);
		model.addObject("userid", userid);
		model.addObject("doj",doj);
		model.addObject("email",email);
		return model;
	}
	
	@RequestMapping(value="/enter_id")
	public String enterid() {

	    return "enter_id";
	}
	
	@RequestMapping(value="/showuser",method=RequestMethod.GET)
	     public ModelAndView showUserByid(@RequestParam("id")int id) throws SQLException{
		ModelAndView model=new ModelAndView("showById");
		DAO dao=new DAO();
		ResultSet rs=dao.getUsersById(id);
		
		List<String>user=new ArrayList<String>();
		while(rs.next()){
			user.add(Integer.toString(rs.getInt("id")));
			user.add(rs.getString("username"));
			user.add(rs.getString("DOJ"));
			user.add(rs.getString("email_id"));
		}
		model.addObject("user",	user);
		return model;
		
	}
	
	@RequestMapping(value="/change_password")
	public String change() {
         
	    return "change_password";
	}
	
	@RequestMapping(value="/change",method=RequestMethod.POST)
     public ModelAndView passChange(@RequestParam("changedpass") String pass) throws SQLException{
		DAO dao=new DAO();
		dao.updatepassword(current_user,pass);
		model=new ModelAndView("user_login");
		model.addObject("msg", "Password Changed");
		return model;
		
	}
	
	@RequestMapping(value="/json",method=RequestMethod.GET)
	public ModelAndView jsonprint() throws SQLException{
		ModelAndView model=new ModelAndView("jsonprint");
		DAO dao=new DAO();
		ResultSet rs=dao.getUsers();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(getFormattedResult(rs));
		System.out.println(json);
		  model.addObject("json",json);
		return model;
	}
	
	public static List<JSONObject> getFormattedResult(ResultSet rs) {
	    List<JSONObject> resList = new ArrayList<JSONObject>();
	    try {
	        // get column names
	        ResultSetMetaData rsMeta = rs.getMetaData();
	        int columnCnt = rsMeta.getColumnCount();
	        List<String> columnNames = new ArrayList<String>();
	        for(int i=1;i<=columnCnt;i++) {
	            columnNames.add(rsMeta.getColumnName(i).toUpperCase());
	        }

	        while(rs.next()) { // convert each object to an human readable JSON object
	            JSONObject obj = new JSONObject();
	            for(int i=1;i<=columnCnt;i++) {
	                String key = columnNames.get(i - 1);
	                String value = rs.getString(i);
	                obj.put(key, value);
	            }
	            resList.add(obj);
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return resList;
	}
}

