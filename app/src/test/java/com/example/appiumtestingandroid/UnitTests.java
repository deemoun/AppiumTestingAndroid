package com.example.appiumtestingandroid;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UnitTests {
    @BeforeSuite
    public void setUp(){
        System.out.println("This method is executed before anything else");
    }

    @Test(description = "Perform calculations")
    public void calculations() {
        assertEquals(4, 2 + 2);
    }

    @AfterSuite
    public void tearDown(){
        System.out.println("This method is executed after all tests are executed");
    }

    @Test()
    @Parameters("username")
    public void testParameters(@Optional("ThisIsOptional") String username)
    {
        System.out.println(username);
    }


}