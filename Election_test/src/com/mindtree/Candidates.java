package com.mindtree;

import javax.persistence.*;

@Entity
@Table(name="candidates")
public class Candidates {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String name;
 
  @ManyToOne
	@JoinColumn(name="con_id", nullable=false)
  private Constituency consti;
  
  private String party;
  Candidates(){
	  
  }
  public Candidates(String name,String party,Constituency c){
	  
	  this.name=name;
	  this.party=party;
	  this.consti=c;
  }
  
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

public String getParty() {
	return party;
}
public void setParty(String party) {
	this.party = party;
}
public Constituency getConsti() {
	return consti;
}
public void setConsti(Constituency consti) {
	this.consti = consti;
}
}
