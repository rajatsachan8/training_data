

class Parent{
	void function1(){
		System.out.println("Parent");
	}
	void function2(){
		System.out.println("FUnction2");
	}
}

class Child extends Parent{
	void function1(){
		System.out.println("child");
	}
	void function3(){
		System.out.println("function3");
	}
	
}

public class inheritance_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Parent parent=new Child();
       parent.function2();
       parent.function1();
      ((Child) parent).function3();
	}

}
