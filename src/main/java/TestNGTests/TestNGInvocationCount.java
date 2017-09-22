package TestNGTests;

import org.testng.annotations.Test;

public class TestNGInvocationCount {
	@Test
	public void test4() {
		System.out.println("Test 4");
	}

	//To Test intermittent Issues or cleaning up page Tests
	@Test(invocationCount=2)
	public void test1() {
		System.out.println("Test 1");
	}
}
