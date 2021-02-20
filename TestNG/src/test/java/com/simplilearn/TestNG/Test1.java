package com.simplilearn.TestNG;

import org.testng.annotations.Test;

public class Test1 {

	@Test(groups= {"Sanity"})
	public void method1() {
		System.out.println("Inside method1");
	}
	
	@Test(groups= {"Regression"})
	public void method2() {
		System.out.println("Inside method2");
	}
	
	@Test(groups= {"Regression"})
	public void method4() {
		System.out.println("Inside method4");
	}
	
	@Test(groups= {"Sanity"}, enabled = false, priority = 1)
	public void method5() {
		System.out.println("Inside method5");
	}
	
}
