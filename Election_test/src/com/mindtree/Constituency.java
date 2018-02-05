package com.mindtree;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="constituency")
public class Constituency {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="con_id")
  private int id;
	
	@Column(name="Name")
  private String name;
	
	@OneToMany(mappedBy="consti")
  private Set<Candidates> cand;
	
	
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<Candidates> getCand() {
	return cand;
}
public void setCand(Set<Candidates> cand) {
	this.cand = cand;
}
  
}
