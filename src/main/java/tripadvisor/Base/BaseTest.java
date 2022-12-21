package tripadvisor.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

/** @author Aman Bhusari
* @date Nov 19, 2022
* 
*/

/**
 * 
 * @Usage: This class is used to initiate the WebDriver Driver,properties file.
 *         All static variables are declared here and inherited by other
 *         classes.
 *
 */

public class BaseTest {

	public static WebDriver driver;
	protected static Properties pro;

	@BeforeMethod
	public void setup() throws IOException {
		pro = new Properties();
		String path = System.getProperty("user.dir") + "./src/main/java/tripadvisor/Resources/config.properties";

		FileInputStream file1 = new FileInputStream(path);
		pro.load(file1);

		ChromeOptions co = new ChromeOptions();
		EdgeOptions eo = new EdgeOptions();

		String Browsername = pro.getProperty("browser");
		if (Browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
		} else if (Browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(eo);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get(pro.getProperty("baseurl"));
	}

	@AfterMethod

	public void TearDown() {
		driver.quit();
	}

}