package runner;

import JunitTest.JUnit_AssertionClassTest;
import JunitTest.JunitAnnotationsExamples;
import JunitTest.MyTestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import page.MessageUtil;

public class TestSuite_TestResult_Classes {

    public static void main(String[] a) {
        // add the test's in the suite
        //public class TestSuite extends Object implements Test
       //A TestSuite is a Composite of Tests.
        // It runs a collection of test cases.
        TestSuite suite = new TestSuite(MyTestCase.class,
                MessageUtil.class,
                JunitAnnotationsExamples.class,
                JUnit_AssertionClassTest.class);

        TestResult result = new TestResult();
        suite.run(result);
        System.out.println("Number of test cases = " + result.runCount());
    }
}
