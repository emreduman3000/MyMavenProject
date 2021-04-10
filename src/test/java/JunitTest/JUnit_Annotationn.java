package JunitTest;

import org.junit.*;

public class JUnit_Annotationn {
//Right click ON PROJECT , CLICK MAVEN , RELOAD
    //ALL TESTS RUNS


    /*
    org.junit.runners.model.InvalidTestClassError:
    Invalid test class 'JunitTest.JUnit_Annotationn':
  1. Method beforeClass() should be static
  2. Method afterClass() should be static
     */
    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("beforeclass");
    }

    @Ignore//IT DOESNT IGNORE, @Ignore used for @Test
    @Before
    public void TestBefore()
    {
        System.out.println("TestBefore");
    }

    @Before
    public void TestBefore1()
    {
        System.out.println("TestBefore1");
    }

    @Before
    public void TestBefore2()
    {
        System.out.println("TestBefore2");
    }

    @Test
    public void Test1()
    {
        System.out.println("Print TEST1");
    }
    /*
   beforeclass
    TestBefore2
    TestBefore1
    TestBefore
    Print TEST1
    TestAfter2
    TestAfter
     */

    //@Ignore//Test2 methodu ve onunla calısıcak before - after methodları ıgnored olucak
    @Test
    @Ignore//DOESNT MATTER WHERE IT IS
    public void Test2()
    {
        System.out.println("Print TEST2");
    }
    //Test ignored.


    @Test
    public void Test3()//herhangi bir test before ve after methodlarını calıstırır
    {
        System.out.println("Print TEST3");
        ignoreTest();
    }

    @Ignore//this method will be executed in Test3
    public void ignoreTest()
    {
        System.out.println("ignoreTest");
    }
    /*
    TestBefore2
    TestBefore1
    TestBefore
    Print TEST3
    TestAfter2
    TestAfter
    afterClass
     */

    @After
    public void TestAfter()
    {
        System.out.println("TestAfter");
    }

    @After
    @Ignore//It doesnt IGNORE
    public void TestAfter2()
    {
        System.out.println("TestAfter2");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("afterClass");
    }
}
