package exceptions.example;

public class Test1 {
	public static void main(String[] args) {
		try {
			int x = 0;
			int y = 5 / x;
		} catch (Exception e) {
			System.out.println("-exception-");
		} catch (ArithmeticException ae) {
			System.out.println("-arithmetic exception-");
		}
		System.out.println("-finished-");
	}
}