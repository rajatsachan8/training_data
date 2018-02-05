package com.mindtree;

import javax.persistence.*;

@Entity
@Table(name="Student3")
public class Student {
     @Id
	private int id;
     
 private String name;
  private String degree;
  
  public int getId(){
	  return id;
  }
  public void setId(int id){
	  this.id=id;
  }
  public String getName(){
	  return name;
  }
  public void setName(String name){
	  this.name=name;
  }
  public String getDegree(){
	  return degree;
  }
  public void setDegree(String degree){
	  this.degree=degree;
  }
}
