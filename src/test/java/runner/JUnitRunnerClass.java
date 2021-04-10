package runner;

import JunitTest.JUnit_AssertionClassTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JUnitRunnerClass {


    //https://www.guru99.com/junit-annotations-api.html

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(JUnit_AssertionClassTest.class);

        for(Failure failure : result.getFailures())
        {
            System.out.println(result.toString());
        }

        /*
        public List<Failure> getFailures() {
            return failures;
        }
         */
        System.out.println(result.getFailures().toString());//[]
        System.out.println("RESULT=="+ result.wasSuccessful());
    }
}
