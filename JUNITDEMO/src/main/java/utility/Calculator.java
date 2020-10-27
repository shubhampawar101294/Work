package utility;

public class Calculator {

	public int add(int a, int b) {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}
		return a + b;
	}

	public int sub(int a, int b) throws Exception {

		return a - b;
	}

	public int mul(int a, int b) throws Exception {

		return a * b;
	}

	public int div(int a, int b) throws Exception {

		return a / b;
	}
}
