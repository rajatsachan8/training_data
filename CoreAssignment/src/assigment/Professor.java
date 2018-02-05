package assigment;



class Professor extends Person {
    private int booksPublished;
  
    Professor(){
   	 
    }
    Professor(String name,int books){
   	 super(name);
   	 booksPublished=books;
    }
    void print(){
   	 System.out.println("Name: "+getName()+" Books Published: "+booksPublished);
    }
    
	boolean isOutstanding() {
		if(booksPublished>4){
			return true;
		}
		else
			return false;
	}
}