package JunitTest;

import junit.framework.TestCase;
import page.ListClass;

public class MyTestCase extends TestCase {

/*
1. Introduction
JUnit provides a class known as TestCase.
This class will help us to run all our test cases.
In previous articles, we have used the @Test annotation on all our test cases.
But, here we will not use any annotation and see how we can test the methods with the help of the TestCase class.
We will create a class by extending the TestCase class and then proceed further for testing.
Let’s start creating a project.
*/

    /*
    Now we are ready to write our main class that will actually run our test cases. We need to follow some points so that we run our test cases:

    We need to extend the TestCase class of JUnit
    setUp() and tearDown() methods, which are optional and runs before and after every test case.
    Every test case shouls be public and name should begin with test. They should not take any argument.
    Test case should not return any value.
     */
        protected ListClass lstTest = new ListClass();
        //list is existed in this object

    //a setUp() method that will run before any test method.
    protected void setUp() {
            lstTest.add("Apple");
            lstTest.add("Orange");
            lstTest.add("Grapes");

        }

        //testcase
        public void testSize() {
            assertEquals("Checking size of List", 3, lstTest.size());
        }

        //testcase
        public void testAdd() {
            lstTest.add("Banana");
            assertEquals("Adding 1 more fruit to list", 4, lstTest.size());
        }

        //testcase
        public void testRemove() {
            lstTest.remove("Orange");
            assertEquals("Removing 1 fruit from list", 2, lstTest.size());
        }

        //the tearDown() method that will be called after each test case.
        protected void tearDown() {
            lstTest.removeAll();
        }
    }

    /*
    5. Conclusion
    We have learned a way to test our test cases with the help of the TestCase class of JUnit.
    Now a days we are using annotations instead of the TestCase class.
    But through JUnit Testcase example we have learned a new way to test.
     */

