package election;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
   public static void main(String[] args){
        int flag=0;
       Configuration cfg = new Configuration();
       cfg.configure("hibernate.cfg.xml");
       
       SessionFactory factory = cfg.buildSessionFactory();
       Session session = factory.openSession();
       Constituency con = new Constituency();
       con.setCon_id(1);
       con.setName("Jayanagar");
       try{
    	   session.save(con); 
       }
        catch(Exception e){
        	System.out.println("Duplicate value");
        	flag=1;
        }
       
       Candidates can=new Candidates();
         can.setCan_id(1);
         can.setName("HariPrasad");
         can.setParty("Congress");
         can.setConstituency(con);
         session.save(can);
         	
       Transaction tx = session.beginTransaction();
       System.out.println("Object saved successfully.....!!");
       tx.commit();
       session.close();
       factory.close();

   }
}
