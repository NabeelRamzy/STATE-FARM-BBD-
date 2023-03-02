package base;

import static utils.IConstant.CHROME;
import static utils.IConstant.EDGE;
import static utils.IConstant.EXPLICIT_WAIT;
import static utils.IConstant.FIREFOX;
import static utils.IConstant.IMPLECIT_WAIT;
import static utils.IConstant.PAGELOAD_WAIT;
import static utils.IConstant.SAFARI;
import static utils.IConstant.URL;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonAction.CommonAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LandingPage;
import utils.ReadProperties;


public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static CommonAction cA;
	public static LandingPage landingPage;
	ReadProperties readProperties = new ReadProperties();;

	
   
	public void setUpDriver(String browsername) {
	//	String browser =  readProperties.getProperty(BROWSER);
		String url =  readProperties.getProperty(URL);
		long pageLoadWait =  readProperties.getNumProperty(PAGELOAD_WAIT);
		long implicitlyWait =  readProperties.getNumProperty(IMPLECIT_WAIT);
		long explicitWait =  readProperties.getNumProperty(EXPLICIT_WAIT);

		initDriver(browsername);
		initClass(driver);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(implicitlyWait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(explicitWait));

	}

	public void initClass(WebDriver driver) {
	landingPage = new LandingPage(driver);
		

	}

	public void initDriver(String driverName) {
		switch (driverName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		}
	}

	
	public void tearUp() {
		driver.quit();

	}
  
	
}
