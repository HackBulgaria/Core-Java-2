package exceptions.example;

public class Test5 {
	static boolean testReturn() {
	    try {
	        return true;
	    }
	    finally {
	        return false;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(testReturn());
	}
}
