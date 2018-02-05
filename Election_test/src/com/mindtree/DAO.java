package com.mindtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DAO {
          Scanner scan=new Scanner(System.in);
          BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        private int con_id;
  		private String constituencyName;
  		private int can_id;
  		private String candidateName;
  		private String partyName;
  		Constituency con=new Constituency();
  		Candidates can=new Candidates();
  		
  		
	public String insertNewData() throws IOException{

		 Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory factory = cfg.buildSessionFactory();
	       Session session = factory.openSession();
	       
		 System.out.println("Enter Constituency Name");
		 constituencyName=scan.next();
		 
		 
		 Query query = session.createQuery("from Constituency where name = :getname ");
		 query.setParameter("getname", constituencyName);
		 List results=query.list();
		 Iterator iterator = results.iterator();
		 Constituency obj = null;
	        while (iterator.hasNext()) {//is next data exist? then loop
	            obj = (Constituency) iterator.next();//cast and assign next data to Person type object
	            
	            System.out.print(obj.getId() + "\t" + obj.getName()+ "\n");
	        }
	       // System.out.println(results.isEmpty());
	        
		 if(results.isEmpty()){
			 System.out.println("Constituency Not found....adding it to the table");
			 System.out.println("Enter the Candidate Name");
			 candidateName=scan.next();
			 System.out.println("Enter the Party Name");
			 partyName=scan.next();
			 con.setName(constituencyName);
			 
			 can=new Candidates(candidateName,partyName,con);
			 Set<Candidates> itemsSet=new HashSet<Candidates>();
			 itemsSet.add(can);
			 con.setCand(itemsSet);
			
		       session.save(con);
		       session.save(can);
		      	
		       Transaction tx = session.beginTransaction();
		       System.out.println("Object saved successfully.....!!");
		       tx.commit();
		       session.close();
		       factory.close();
		       
		 }
		 else{
			 
			 System.out.println("Constituency found");
			 
			 System.out.println("Enter the Candidate Name");
			 candidateName=scan.next();
			 System.out.println("Enter the Party Name");
			 partyName=scan.next();
			 con.setId(obj.getId());
			 con.setName(constituencyName);
			 
			 can=new Candidates(candidateName,partyName,con);
			 Set<Candidates> itemsSet=new HashSet<Candidates>();
			 itemsSet.add(can);
			 con.setCand(itemsSet);
			   
		       session.save(can);
		      	
		       Transaction tx = session.beginTransaction();
		       System.out.println("Object saved successfully.....!!");
		       tx.commit();
		       session.close();
		       factory.close();
		 }
		 return candidateName;
		 
			}
       public void showDetails(){

  		 Configuration cfg = new Configuration();
  	       cfg.configure("hibernate.cfg.xml");
  	       
  	       SessionFactory factory = cfg.buildSessionFactory();
  	       Session session = factory.openSession();
  	       
    	   System.out.println("Enter the Constituency ID");
    	   con_id=scan.nextInt();
    	   Query query=session.createQuery("from Candidates");
//    	   query.setParameter("getname", con_id);
    	   List list=query.list();
    	   Iterator iterator = list.iterator();
    	    if(list.isEmpty()){
    	    	System.out.println("Not found");
    	    	return;
    	    }
  		   Candidates obj = null;
  	        while (iterator.hasNext()) {//is next data exist? then loop
  	            obj = (Candidates) iterator.next();
  	            if(obj.getConsti().getId()==con_id){
  	  	            System.out.println(obj.getName()+"\t"+obj.getParty()+"\t"+obj.getConsti().getName());
  	            }
  	            
  	        }
  	      session.close();
	       factory.close();
       }
       
       public void showName(){
    	   Configuration cfg = new Configuration();
  	       cfg.configure("hibernate.cfg.xml");
  	       
  	       SessionFactory factory = cfg.buildSessionFactory();
  	       Session session = factory.openSession();
  	       
  	       System.out.println("Enter the party");
  	       partyName=scan.next();
  	       Query query=session.createQuery("from Candidates");
  	       List list=query.list();
  	       Iterator iterator=list.iterator();
  	       Candidates obj=null;
  	         if(list.isEmpty()){
  	        	 System.out.println("Not Found");
  	        	 return;
  	         }
  	       while(iterator.hasNext()){
  	    	   obj=(Candidates) iterator.next();
  	    	   if(obj.getParty().equals(partyName)){
  	    		   System.out.println(obj.getName()+"\t  "+obj.getConsti().getName());
  	    	   }
  	       }
  	     session.close();
	       factory.close();
       }
       
	public List<Candidates> contestants() {
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory factory = cfg.buildSessionFactory();
	       Session session = factory.openSession();
	       
		System.out.println("Enter Constituency Name");
		 constituencyName=scan.next();
		Query query=session.createQuery("from Candidates");
		List list=query.list();
		Iterator iterator=list.iterator();
		Candidates obj=null;
		if(list.isEmpty()){
			System.out.println("Not Found");
			return null;
		}
		List<Candidates> candidates = new ArrayList();
		while(iterator.hasNext()){
			obj=(Candidates)iterator.next();
			if(obj.getConsti().getName().equals(constituencyName)){
				System.out.println(obj.getName()+"\t"+obj.getParty());
				candidates.add(obj);
			}
		}
		 session.close();
	       factory.close();
	       return candidates;
	}
	public void partyAndConsti() {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory factory = cfg.buildSessionFactory();
	       Session session = factory.openSession();
	       
	       System.out.println("Enter the party name");
	       partyName=scan.next();
	       System.out.println("Enter the Constituency Name");
	       constituencyName=scan.next();
	       Query query=session.createQuery("from Candidates");
	       List list=query.list();
			Iterator iterator=list.iterator();
			Candidates obj=null;
			if(list.isEmpty()){
				System.out.println("Not Found");
				return;
			}
			while(iterator.hasNext()){
				obj=(Candidates)iterator.next();
				if(obj.getConsti().getName().equals(constituencyName) && obj.getParty().equals(partyName)){
					System.out.println(obj.getName());
				}
			}
	}
	public List allcandidates(){
		List<Candidates> candi=new ArrayList();
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory factory = cfg.buildSessionFactory();
	       Session session = factory.openSession();
	       Query query=session.createQuery("from Candidates");
			List list=query.list();
			Iterator iterator=list.iterator();
			Candidates obj=null;
			while(iterator.hasNext()){
				obj=(Candidates)iterator.next();
					candi.add(obj);
				}
			
		return candi;
		
	}
}
