package TestNGTests;

import org.testng.annotations.Test;

public class TestNGEnable {
	@Test
	public void test4() {
		System.out.println("Test 4");
	}

	@Test(enabled=false)
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test(enabled=true)
	public void test3() {
		System.out.println("Test 3");
	}
}
