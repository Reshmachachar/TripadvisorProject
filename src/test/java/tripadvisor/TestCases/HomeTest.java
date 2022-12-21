package tripadvisor.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import tripadvisor.Base.BaseTest;
import tripadvisor.ExtentListener.ExtentListeners;
import tripadvisor.Pages.HolidayHome;

/* @author Aman Bhusari
* @date Nov 20, 2022
* 
*/

/**
 * 
 * @Usage: This is a Test class for HolidayHome of Tripadvisor website.
 * 
 *
 */

public class HomeTest extends BaseTest {
	
	HolidayHome home;
	

	@Test(description="Display total amount and charges per night for 3 holiday homes for 4 peoples from 12th Dec to 18th Dec")
	public void TC01_DispalyTotalChargesForFourPeopels() throws IOException, InterruptedException {
	
		home = new HolidayHome(driver);
		home.clickOnHolidayHome().click();
		home.clickOnNearby().click();
		home.checkIn().click();
		home.selectChekInDate(pro.getProperty("checkInDate"), pro.getProperty("month"));
		home.checkOut().click();
		home.selectChekOutDate(pro.getProperty("checkOutDate"), pro.getProperty("month"));
		home.guestDropdown().click();
		for (int i = 0; i < 2; i++) {
			home.selectGuest().click();
		}
		home.applyBtn().click();
		String selectedguest = home.noOfGuest().getText().substring(9, 17);
		ExtentListeners.test.log(Status.INFO, "Holiday Home selected for " + selectedguest);
		Assert.assertEquals(selectedguest, "4+ guest");

		String dispalyDates = home.selectedDate().getText();
		ExtentListeners.test.log(Status.INFO, "Selected dates are " + dispalyDates);
		Assert.assertEquals(dispalyDates, "15/12/22 - 18/12/22");
		String firstRate = home.firstCharge().getText().replace('₹', ' ');
		String secondRate = home.secondCharge().getText().replace('₹', ' ');
     	String thirdRate = home.thirdCharge().getText().replace('₹', ' ');
		
     	ExtentListeners.test.log(Status.INFO, "Total amount and charges per night for 1 st holiday homes---- " + firstRate);
		ExtentListeners.test.log(Status.INFO, "Total amount and charges per night for 2 nd holiday homes----" + secondRate);
		ExtentListeners.test.log(Status.INFO, "Total amount and charges per night for 3 rd holiday homes----" + thirdRate);
	}

	@Test(description="Sort the list with highest traveler rating on top and display total amount and charges per night for 3 holiday homes ")
	public void TC02_ListSortWithTravelerRating() {

		home = new HolidayHome(driver);

		home.clickOnHolidayHome().click();
		home.clickOnNearby().click();

		home.checkIn().click();
		home.selectChekInDate(pro.getProperty("checkInDate"), pro.getProperty("month"));
		home.checkOut().click();
		home.selectChekOutDate(pro.getProperty("checkOutDate"), pro.getProperty("month"));

		home.sortFilter().click();
		home.travellerRating().click();
		String sorrtedFilter = home.sortFilter().getText();
		
		ExtentListeners.test.log(Status.INFO, "List has been sorted with----" + sorrtedFilter);
		Assert.assertEquals(sorrtedFilter, "Traveller Rating");
		String firstRate = home.firstCharge().getText().replace('₹', ' ');
		String secondRate = home.secondCharge().getText().replace('₹', ' ');
     	String thirdRate = home.thirdCharge().getText().replace('₹', ' ');
     	
     	ExtentListeners.test.log(Status.INFO, "Total amount and charges per night for 1 st holiday homes---- " + firstRate);
		ExtentListeners.test.log(Status.INFO, "Total amount and charges per night for 2 nd holiday homes----" + secondRate);
		ExtentListeners.test.log(Status.INFO, "Total amount and charges per night for 3 rd holiday homes----" + thirdRate);
	}

	@Test(description="Holiday home should have elevator/ Lift access and display total amount and charges per night for 3 holiday homes ")

	public void TC03_HolidayHomeWithLiftAccess() {

		home = new HolidayHome(driver);

		home.clickOnHolidayHome().click();
		home.clickOnNearby().click();

		home.checkIn().click();
		home.selectChekInDate(pro.getProperty("checkInDate"), pro.getProperty("month"));
		home.checkOut().click();
		home.selectChekOutDate(pro.getProperty("checkOutDate"), pro.getProperty("month"));		
		
		home.showAllBtn().click();
		home.LiftCheckBox().click();
		home.anemities().click();

		String liftfilter = home.dispalyLiftFilter().getText();
		ExtentListeners.test.log(Status.INFO, "Holiday home has been sorted with----" + liftfilter);
		Assert.assertEquals(liftfilter, "Elevator/Lift access");
		
		String firstRate = home.firstCharge().getText().replace('₹', ' ');
		String secondRate = home.secondCharge().getText().replace('₹', ' ');
     	String thirdRate = home.thirdCharge().getText().replace('₹', ' ');
     	
     	ExtentListeners.test.log(Status.INFO, "Total amount and charges per night for 1 st holiday homes---- " + firstRate);
		ExtentListeners.test.log(Status.INFO, "Total amount and charges per night for 2 nd holiday homes----" + secondRate);
		ExtentListeners.test.log(Status.INFO, "Total amount and charges per night for 3 rd holiday homes----" + thirdRate);
	}
}
