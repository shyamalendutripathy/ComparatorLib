package cleartrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginInstance {
	private static WebDriver driver;
	private static LoginInstance loginInstance;
	private LoginInstance(){
		
	}
	
	public static  LoginInstance init(){
		if(loginInstance==null){
			loginInstance=new LoginInstance();
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			options.addArguments("--test-type");
			options.addArguments("--disable-notifications");

			driver=new ChromeDriver(options);

			driver.get("https://www.cleartrip.com/");
			driver.manage().window().maximize();
		}
		return loginInstance;
	}
	
	public WebDriver returnDriver(){
		return driver;        
	}
}
