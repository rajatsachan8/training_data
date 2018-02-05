package election;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="Constituency")
public class Constituency {

private int con_id;
 private String name;
 
 Constituency(){
	 
 }
 @Column(name="Name")
 public String getName(){
	 return name;
 }
 public void setName(String name){
	 this.name=name;
 }
 
@Id
@Column(name="ConstituencyId")
public int getCon_id() {
	return con_id;
}

public void setCon_id(int con_id) {
	this.con_id = con_id;
}

}
