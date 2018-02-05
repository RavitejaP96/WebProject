package com.orbitz.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("On Finish:"+result.getName());
		
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("On Start:"+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On TestFailedButWithinSuccessPercentage:"+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On TestFailure:"+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On TestSkipped:"+result.getName());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Finish:"+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Finish:"+result.getName());
		
	}

}

