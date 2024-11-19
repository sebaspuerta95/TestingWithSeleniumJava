package dependencyAttributes;

import org.testng.annotations.Test;

/**
 * This test class is not meant to test something, but to show how dependency can be managed instead.
 * It uses the dependsOnMethods, Groups and dependsOnGroups attributes of the Test annotation.
 *
 * All the tests that belong to a group that a test depends on, are guaranteed to be run before the dependant test is run.
 * These are hard dependencies, so the execution of subsequent methods will be skipped if a method fails, so it prevent a cascade effect that would show multiple failures, which is incorrect.
 */
public class DependencyExampleTests {

    @Test (groups = "initialize")
    public void test1_SetUpChrome() {}

    @Test (groups = "initialize", dependsOnMethods = "test1_SetUpChrome")
    public void test2_OpenOrangeHRM() {}

    // Tests from "initialize" group are guaranteed to be run before test3_SignIn() can be run.
    @Test (dependsOnGroups = "initialize", groups = "env_application")
    public void test3_SignIn() {}

    @Test (groups = "postLoginAction", dependsOnMethods ={"test2_OpenOrangeHRM", "test3_SignIn"} )
    public void test4_SearchUser() {}

    @Test (groups = "postLoginAction", dependsOnMethods={"test2_OpenOrangeHRM", "test3_SignIn"} )
    public void test5_SearchEmployee() {}

    @Test (groups = "postLoginAction", dependsOnMethods={"test2_OpenOrangeHRM", "test3_SignIn"} )
    public void test6_SearchCandidate() {}

    // Signing Out depends on the "postLoginAction" group.
    @Test (dependsOnGroups= "postLoginAction" )
    public void test7_SignOut() {}

    // The alwaysRun attribute is used to run the method no matter if the test it depends on fails. Useful in tear down methods.
    @Test (dependsOnMethods = "test7_SignOut", alwaysRun = true)
    public void test8_TearDown(){}

}
