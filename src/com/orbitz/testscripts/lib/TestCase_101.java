package com.orbitz.testscripts.lib;

import org.testng.annotations.Test;

import com.orbitz.pages.lib.FlightsPageInfo;
import com.orbitz.utility.Base;

public class TestCase_101 extends Base {

	FlightsPageInfo flights;

	@Test
	public void flightBookingExecution() throws Exception {

		flights = new FlightsPageInfo(driver);
		flights.flightBooking();
		System.out.println("TestCase_101 Executed");
	}

}
