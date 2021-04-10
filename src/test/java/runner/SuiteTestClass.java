package runner;

import JunitTest.JunitAnnotationsExamples;
import JunitTest.MessageUtilTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class)

    @Suite.SuiteClasses(
    {
        JunitAnnotationsExamples.class,
        MessageUtilTest.class
    }
    )

    public class SuiteTestClass {
    }

