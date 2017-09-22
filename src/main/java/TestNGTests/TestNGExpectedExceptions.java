package TestNGTests;

import org.testng.annotations.Test;

import javaClasses.BankAccountVersion2;
import javaClasses.InsufficientBalanceException;

public class TestNGExpectedExceptions {

	@Test(expectedExceptions={InsufficientBalanceException.class})
	public void test() throws InsufficientBalanceException {
		BankAccountVersion2 b = new BankAccountVersion2(1234, "Yagna", 500, true);
		b.withdraw(1000);
	}
}
