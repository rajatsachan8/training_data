package assigment;

class Student extends Person{
	private double percentage;
	
	Student(){
		
	}
	Student(String name,double percent){
		super(name);
		this.percentage=percent;
	}
	void display(){
		System.out.println("Name: "+getName()+" Percentage: "+percentage);
	}
	
	boolean isOutstanding(){
		if(percentage>=85){
			return true;
		}
		else 
		{
			return false;
		}
	}
}