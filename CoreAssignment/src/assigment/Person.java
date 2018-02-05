package assigment;


abstract class Person{
	private String pName;
	Person(){
	
	}
	Person(String name){
		pName=name;
	}
	 String getName() {
		return pName;
	}
	
	 void setName(String name) {
		 pName=name;
	}
	 
	 abstract boolean isOutstanding();

}