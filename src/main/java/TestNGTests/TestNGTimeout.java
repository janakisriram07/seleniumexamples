package TestNGTests;

import org.testng.annotations.Test;

public class TestNGTimeout {
	@Test(timeOut=1000)
	public void test() throws InterruptedException {
		Thread.sleep(3000);
	}
}
