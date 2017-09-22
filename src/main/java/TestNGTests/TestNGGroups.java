package TestNGTests;

import org.testng.annotations.Test;

@Test(groups={"sanity"})
public class TestNGGroups {
	@Test(groups={"functional","login"})
	public void loginTest() {
		System.out.println("Logging in ..");
	}

	@Test(dependsOnGroups={"functional"})
	public void signOut() {
		System.out.println("Signing Out ...");
	}

	@Test(groups={"functional"},dependsOnMethods={"loginTest"})
	public void addReport() {
		System.out.println("Adding Report ... ");
	}

}
