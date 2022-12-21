package tripadvisor.TestCases;

import org.testng.annotations.Test;

import tripadvisor.Base.BaseTest;
import tripadvisor.Pages.HolidayHome;

public class HolidayHomeTest extends BaseTest{
	HolidayHome home;
	
	@Test
	public void TC_01_validationOfHotelSearchesWithCapacityOfFourPeoples() 
	{
		home = new HolidayHome(driver);
		home.guestListCount();
	}
	
	@Test
	public void Tc_002_travellerRatingVarificationForHolidayHomes() 
	{
		home = new HolidayHome(driver);
		home.ratingVarification();
	}
	@Test
	public void Tc_003_holidayHomeWithLiftAccess() 
	{
		home = new HolidayHome(driver);
		home.holidayHomeWithLiftAccess();
	}
	
	@Test
	public void Tc_004_dateValidationforFirstHolidayHome() 
	{
		home = new HolidayHome(driver);
		home.dateValidationForFirstHome();
	}
	
	@Test
	public void Tc_005_dateValidationforSecondHolidayHome() 
	{
		home = new HolidayHome(driver);
		home.dateValidationForSecondHome();
	}
	
	@Test
	public void Tc_006_dateValidationforThirdHolidayHome()
	{
		home = new HolidayHome(driver);
		home.dateValidationForThirdHome();
	}
	
	
	
	
}
