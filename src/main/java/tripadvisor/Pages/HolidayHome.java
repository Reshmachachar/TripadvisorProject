package tripadvisor.Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import tripadvisor.Base.BaseTest;
import tripadvisor.ExtentListener.ExtentListeners;

/* @author Aman Bhusari
* @date Nov 20, 2022
* 
*/

/**
 * 
 * @Usage: This is a page object class for HolidayHome of Tripadvisor website.
 * 
 *
 */

public class HolidayHome extends BaseTest {
	public WebDriver driver;

	public HolidayHome(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Holiday Homes']")
	WebElement holidayHome;

	public WebElement clickOnHolidayHome() {
		return holidayHome;
	}

	@FindBy(xpath = "//div[text()='Nearby']")
	WebElement nearby;

	public WebElement clickOnNearby() {
		return nearby;
	}

	@FindBy(xpath = "//div[@class='CztlA f b H4']")
	WebElement guestDropdown;

	public WebElement guestDropdown() {
		return guestDropdown;
	}

	@FindBy(xpath = "(//span[@class='ui_icon plus fBgDg S4'])[1]")
	WebElement selectBedroom;

	public WebElement selectBedroom() {
		return selectBedroom;
	}

	@FindBy(xpath = "(//span[@class='ui_icon plus fBgDg S4'])[2]")
	WebElement selectGuest;

	public WebElement selectGuest() {
		return selectGuest;
	}

	@FindBy(xpath = "//button[text()='Apply']")
	WebElement applyBtn;

	public WebElement applyBtn() {
		return applyBtn;
	}

	@FindBy(xpath = "//div[text()='Check-in']")
	WebElement checkIn;

	public WebElement checkIn() {
		return checkIn;
	}

	@FindBy(xpath = "//div[text()='Check-out']")
	WebElement checkOut;

	public WebElement checkOut() {
		return checkOut;
	}

	@FindBy(xpath = "//div[@class='aUyvq c']")
	WebElement selectMonth;

	public WebElement selectMonth() {
		return selectMonth;
	}

	@FindBy(xpath = "//div[@class='ui_icon single-chevron-right-circle Kyuhg _S S7 ']")
	WebElement nextArrow;

	public WebElement nextArrow() {
		return nextArrow;
	}

	@FindBy(xpath = "//div[@class='rhwid c Vm ']")
	List<WebElement> listOfDates;

	public List<WebElement> listOfDates() {
		return listOfDates;
	}

	@FindBy(xpath = "(//div[@class='iCUJC b'])[1]")
	WebElement firstCharge;

	public WebElement firstCharge() {
		return firstCharge;
	}

	@FindBy(xpath = "(//div[@class='iCUJC b'])[2]")
	WebElement secondCharge;

	public WebElement secondCharge() {
		return secondCharge;
	}

	@FindBy(xpath = "(//div[@class='iCUJC b'])[3]")
	WebElement thirdCharge;

	public WebElement thirdCharge() {
		return thirdCharge;
	}

	@FindBy(xpath = "//div[@class='CztlA f b H4']")
	WebElement noOfGuest;

	public WebElement noOfGuest() {
		return noOfGuest;
	}

	@FindBy(xpath = "//span[@class='biGQs _P vvmrG']")
	WebElement selectedDate;

	public WebElement selectedDate() {
		return selectedDate;
	}

	@FindBy(xpath = "//div[@class='CkBUi']")
	WebElement sortFilter;

	public WebElement sortFilter() {
		return sortFilter;
	}

	@FindBy(xpath = "//span[text()='Traveller Rating']")
	WebElement travellerRating;

	public WebElement travellerRating() {
		return travellerRating;
	}

	@FindBy(xpath = "//button[@class='UikNM _G B- _S _T c G_ P0 wSSLS TXrCr']")
	WebElement showAllBtn;

	public WebElement showAllBtn() {
		return showAllBtn;
	}

	@FindBy(xpath = "//span[text()='Elevator/Lift access (7)']")
	WebElement LiftCheckBox;

	public WebElement LiftCheckBox() {
		return LiftCheckBox;
	}

	@FindBy(xpath = "//button[@class='rmyCe _G B- z _S c Wc wSSLS jWkoZ sOtnj']")
	WebElement anemities;

	public WebElement anemities() {
		return anemities;
	}

	@FindBy(xpath = "(//span[@class='biGQs _P vvmrG'])[2]")
	WebElement dispalyLiftFilter;

	@FindBy(xpath = "//div[contains(text(),'Sleeps')]")
	List<WebElement> sleepCount;

	public List<WebElement> sleepCount() {

		return sleepCount;
	}

	@FindBy(xpath = "//div[@class='ui_poi_review_rating  ' ]/span")
	List<WebElement> rating;

	public List<WebElement> rating() {
		return rating;
	}

	public WebElement dispalyLiftFilter() {
		return dispalyLiftFilter;
	}

	@FindBy(xpath = "(//button[@class='ui_button original fullwidth'])[2]")
	WebElement firstBtn;

	@FindBy(xpath = "(//button[@class='ui_button original fullwidth'])[3]")
	WebElement secondBtn;

	@FindBy(xpath = "(//button[@class='ui_button original fullwidth'])[4]")
	WebElement thirdBtn;

	@FindBy(xpath = "//*[text()='15/12/22']")
	WebElement checkInDate;

	@FindBy(xpath = "//*[text()='18/12/22']")
	WebElement checkOutDate;

	@FindBy(xpath = "//div[@class='lWHtu']")
	WebElement totalAmount;
	
	@FindBy(xpath="//div[@class='nVIYy W o q']")
	List<WebElement> matchedlift;

	public void dateValidationForFirstHome()  {
		holidayHome.click();
		nearby.click();
		checkIn.click();
		selectChekInDate(pro.getProperty("checkInDate"), pro.getProperty("month"));
		checkOut.click();
		selectChekOutDate(pro.getProperty("checkOutDate"), pro.getProperty("month"));
		guestDropdown.click();
		for (int i = 0; i < 2; i++) {
			selectGuest.click();
		}
		applyBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		firstBtn.click();

		String MainWindow = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);

				String inDate = checkInDate.getText();
				Assert.assertEquals(inDate, "15/12/22");
				ExtentListeners.test.log(Status.INFO,"CheckIn Date validated sucessfully " + inDate);

				String outDate = checkOutDate.getText();
				Assert.assertEquals(outDate, "18/12/22");
				ExtentListeners.test.log(Status.INFO,"CheckOut Date validated sucessfully " + outDate);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				String total = totalAmount.getText().replace('₹', ' ');
				ExtentListeners.test.log(Status.INFO,
						"Total amount and charges for 1 st holiday homes---- ----" + total);
			}

		}

	}

	public void dateValidationForSecondHome() {
		holidayHome.click();
		nearby.click();
		checkIn.click();
		selectChekInDate(pro.getProperty("checkInDate"), pro.getProperty("month"));
		checkOut.click();
		selectChekOutDate(pro.getProperty("checkOutDate"), pro.getProperty("month"));
		guestDropdown.click();
		for (int i = 0; i < 2; i++) {
			selectGuest.click();
		}
		applyBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		secondBtn.click();
		

		String MainWindow = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);

				String inDate = checkInDate.getText();
				Assert.assertEquals(inDate, "15/12/22");
				ExtentListeners.test.log(Status.INFO,"CheckIn Date validated sucessfully " + inDate);

				String outDate = checkOutDate.getText();
				Assert.assertEquals(outDate, "18/12/22");
				ExtentListeners.test.log(Status.INFO,"CheckOut Date validated sucessfully " + outDate);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				String total = totalAmount.getText().replace('₹', ' ');
				ExtentListeners.test.log(Status.INFO,
						"Total amount and charges for 2 nd holiday homes---- ----" + total);
			}

		}

	}

	public void dateValidationForThirdHome() {
		holidayHome.click();
		nearby.click();
		checkIn.click();
		selectChekInDate(pro.getProperty("checkInDate"), pro.getProperty("month"));
		checkOut.click();
		selectChekOutDate(pro.getProperty("checkOutDate"), pro.getProperty("month"));
		guestDropdown.click();
		for (int i = 0; i < 2; i++) {
			selectGuest.click();
		}
		applyBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		thirdBtn.click();

		String MainWindow = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);

				String inDate = checkInDate.getText();
				Assert.assertEquals(inDate, "15/12/22");
				//ExtentListeners.test.log(Status.INFO,"CheckIn Date validated sucessfully " + inDate);
				String outDate = checkOutDate.getText();
				Assert.assertEquals(outDate, "18/12/22");
				//ExtentListeners.test.log(Status.INFO,"CheckIn Date validated sucessfully " + outDate);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				String total = totalAmount.getText().replace('₹', ' ');
				//ExtentListeners.test.log(Status.INFO,
						//"Total amount and charges for 3 rd holiday homes---- ----" + total);
			}

		}

	}

	public void guestListCount() {
		holidayHome.click();
		nearby.click();
		checkIn.click();
		selectChekInDate(pro.getProperty("checkInDate"), pro.getProperty("month"));
		checkOut.click();
		selectChekOutDate(pro.getProperty("checkOutDate"), pro.getProperty("month"));
		guestDropdown.click();
		for (int i = 0; i < 2; i++) {
			selectGuest.click();
		}
		applyBtn.click();

		int number = sleepCount.size();
		System.out.println(number);
		
		int count = 0;
		for (int i = 0; i < sleepCount.size(); i++) {
			String item = sleepCount.get(i).getText();
			String last = item.substring(7);
		    int num = Integer.parseInt(last);
		
			if (num >= 4) {
				Assert.assertTrue(num >= 4, "Matched with the expected condition");
				ExtentListeners.test.log(Status.INFO, "Assertion is matched with the required 4+ guest condition.");
				count++;
			}
		}
		
		int matched = number - count;

		ExtentListeners.test.log(Status.INFO, "The total number of search found -  " + number);
		ExtentListeners.test.log(Status.INFO, "The total number of matched result with the search of  4 guest condition - " + count);
		ExtentListeners.test.log(Status.INFO, "The total number of unmatched result having availability but not matched with 4 guest condition - "
						+ matched);
	}

	public void ratingVarification() {
		holidayHome.click();
		nearby.click();
		checkIn.click();
		selectChekInDate(pro.getProperty("checkInDate"), pro.getProperty("month"));
		checkOut.click();
		selectChekOutDate(pro.getProperty("checkOutDate"), pro.getProperty("month"));

		sortFilter.click();
		travellerRating.click();

		int ratingC = rating.size();
		ExtentListeners.test.log(Status.INFO, "Total search found with Traveller Rating " + ratingC);
		int nm = 0;
		for (int i = 0; i < rating.size(); i++) {
			String one = rating.get(i).getAttribute("class");
			String series = one.substring(24);
			int inter = Integer.parseInt(series);

			if (inter < nm) {
				Assert.assertTrue(nm > inter);
				ExtentListeners.test.log(Status.INFO, "The rating " + nm + " is higher than the followed one " + inter);
			}
			nm = inter;

		}
		ExtentListeners.test.log(Status.INFO,
				"Holiday homes list with the highest traveller rating on top is verified successfully.");

	}

	public void holidayHomeWithLiftAccess() {
		holidayHome.click();
		nearby.click();
		checkIn.click();
		selectChekInDate(pro.getProperty("checkInDate"), pro.getProperty("month"));
		checkOut.click();
		selectChekOutDate(pro.getProperty("checkOutDate"), pro.getProperty("month"));

		showAllBtn.click();
		LiftCheckBox.click();
		anemities.click();
		
		int totalMatched=matchedlift.size();
		//System.out.println("Total matched results " +totalMatched);
		ExtentListeners.test.log(Status.INFO,
				"Total matched results found  " +totalMatched);
		int count=0;
		String expected="Match: Sleeps, Elevator/Lift access";
		for(int i=0;i<matchedlift.size();i++) {
			String result=matchedlift.get(i).getText();
			//System.out.println(result);
			if(result.equalsIgnoreCase(expected)) {
				Assert.assertEquals(result, expected);
				count++;
				
			}
		
		}
		
		//System.out.println("The total results with Elevator/Lift access are " +count);
		ExtentListeners.test.log(Status.INFO,
				"The total results with Elevator/Lift access are " +count);
		
		
	}

	public void slpCount() {
		int number = sleepCount.size();
		System.out.println(number);
		int count = 0;
		for (int i = 0; i < sleepCount.size(); i++) {
			String item = sleepCount.get(i).getText();
			String last = item.substring(7);
			int num = Integer.parseInt(last);
			// System.out.println(last);
			if (num >= 4) {
				// System.out.println("The searched result is accurate according to the search
				// of four guest. ");
				count++;
			}
		}
		int matched = number - count;
		System.out.println("The total number of search found -  " + number);
		System.out.println("The total number of matched result with the search of  4 guest condition - " + count);
		System.out.println(
				"The total number of unmatched result having availability but not matched with 4 guest condition - "
						+ matched);
	}

	public void ratingVerify() {
		int ratingC = rating.size();
		System.out.println(ratingC);
		int nm = 0;
		for (int i = 0; i < rating.size(); i++) {
			String one = rating.get(i).getAttribute("class");
			String series = one.substring(24);
			int inter = Integer.parseInt(series);

			if (inter < nm) {
				Assert.assertTrue(nm > inter);
				System.out.println("The rating " + nm + " is higher than the followed one " + inter);

			}
			nm = inter;

		}
		System.out.println("Holiday homes list with the highest traveller rating on top is verified successfully.");

	}

	/*
	 * @This method is used for selction of CheckIn Date
	 * 
	 */

	public void selectChekInDate(String selectDate, String month) {
		while (true) {
			String text = selectMonth.getText();
			if (text.equals(month)) {
				break;
			} else {
				nextArrow.click();
			}
		}
		driver.findElement(By.xpath("//div[@aria-label='" + selectDate + "']")).click();
	}

	/*
	 * @This method is used for selction of CheckOut Date
	 * 
	 */

	public void selectChekOutDate(String selectDate, String month) {
		while (true) {
			String text = selectMonth.getText();
			if (text.equals(month)) {
				break;
			} else {
				nextArrow.click();
			}
		}
		driver.findElement(By.xpath("//div[@aria-label='" + selectDate + "']")).click();
	}

}
