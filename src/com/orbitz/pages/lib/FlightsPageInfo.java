package com.orbitz.pages.lib;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.orbitz.utility.Base;

/**
 * .. FlightsPage class maintains all the objects and actions information
 * 
 * @author Raviteja.palnati
 *
 */

public class FlightsPageInfo {

	@FindBy(id = "primary-header-flight")
	WebElement flightsButton;

	@FindBy(id = "tab-flight-tab")
	WebElement flightsOnlyButton;

	@FindBy(id = "flight-type-roundtrip-label")
	WebElement roundTripButton;

	@FindBy(id = "flight-origin")
	WebElement originTextField;

	@FindBy(id = "flight-destination")
	WebElement destinationTextField;

	@FindBy(id = "flight-departing")
	WebElement departingTextField;

	@FindBy(id = "flight-returning")
	WebElement returningTextField;

	@FindBy(id = "search-button")
	WebElement searchButton;

	WebDriverWait wait;

	/*
	 * Using the constructor initializing the driver object with init elements
	 */
	public FlightsPageInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	/* Clicking on flights,flights only,round trip */
	public void clickOnFlights() {
		flightsButton.click();
		flightsOnlyButton.click();
		roundTripButton.click();
		System.out.println("Clicked on Flights,FlightsOnly,Roundtrip buttons");
	}

	/* Passing values in to text field and selecting the given option */
	public void flightTicketBookingExecution() throws Exception {
		originTextField.click();
		Thread.sleep(1000);
		originTextField.sendKeys("Pune");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aria-option-0")));
		originTextField.sendKeys(Keys.ARROW_DOWN);
		originTextField.sendKeys(Keys.ENTER);
		System.out.println("Entered pune in the searchbox");

		destinationTextField.click();
		destinationTextField.sendKeys("Delhi");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aria-option-0")));
		destinationTextField.sendKeys(Keys.ARROW_DOWN);
		destinationTextField.sendKeys(Keys.ENTER);
		System.out.println("Entered delhi in the searchbox");
	}

	/* Selecting dates from calendar */
	public void selectingDates() {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 0);
		date = calendar.getTime();
		String departingDate = format.format(date);
		System.out.println(departingDate);
		departingTextField.click();
		departingTextField.sendKeys(departingDate);

		returningTextField.clear();
		returningTextField.click();
		calendar.add(Calendar.DATE, 2);
		date = calendar.getTime();
		String returnigDate = format.format(date);
		System.out.println(returnigDate);
		returningTextField.sendKeys(returnigDate);

	}

	/* Clicking on search button */
	public void clickSearchButton() {
		searchButton.click();
		System.out.println("clicked on search");
	}

	/* Creating method to access all the initialized elements */
	public void flightBooking() throws Exception {
		clickOnFlights();
		flightTicketBookingExecution();
		selectingDates();
		clickSearchButton();
	}

}
