package election;

import javax.persistence.*;

@Entity
@Table(name="Candidates")
public class Candidates {
    private int can_id;
    private String name;
    private String party;

    private Constituency constituency;
    
    Candidates(){
    	
    }
    
    public String getName(){
    	return name;
    }
    public void setName(String name){
    	this.name=name;
    }
   
    
    public String getParty(){
    	return party;
    }
    public void setParty(String party){
    	this.party=party;
    }
    @Id
    @Column(name="ID")
	public int getCan_id() {
		return can_id;
	}

	public void setCan_id(int can_id) {
		this.can_id = can_id;
	}
	 @ManyToOne(targetEntity=Constituency.class,cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	    @JoinColumn(name="ConstituencyId")
	public Constituency getConstituency() {
		return constituency;
	}

	public void setConstituency(Constituency constituency) {
		this.constituency = constituency;
	}


	
}
