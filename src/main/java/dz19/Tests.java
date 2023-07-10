package dz19;

import dz19.Annotations.AfterSuite;
import dz19.Annotations.BeforeSuite;
import dz19.Annotations.Test;

public class Tests {
    @BeforeSuite
    public void init(){
        System.out.println("Initializing tests");
    }
    @Test(priority = 3)
    public void test1(){
        System.out.println("Test 1 is done!");
    }
    @Test(priority = 1)
    public void test2(){
        System.out.println("Test 2 is done!");
    }
    @Test(priority = 2)
    public void test3(){
        System.out.println("Test 3 is done!");
    }
    @AfterSuite
    public void close(){
        System.out.println("Ending tests");
    }
}
