package pagefactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchCalendarFactory {
	
	@FindAll(@FindBy(how=How.XPATH, using ="//input[@id='DepartDate']")) WebElement departDateTextBox;
	@FindAll(@FindBy(how=How.XPATH, using ="//input[@id='ReturnDate']")) WebElement returnDateTextBox;
	
	public void selectDepartDate(WebDriver driver){
		departDateTextBox.click();
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		String currDate=dateFormat.format(date);
		String[] splitDate=currDate.split("/");
		
		Integer intVal=Integer.parseInt(splitDate[1]);
		String destDatePath="//div[@id='ui-datepicker-div']//table//tr//td[@data-month="+--intVal+"][@data-year="+splitDate[2]+"]";
		
		List<WebElement> departList=driver.findElements(By.xpath(destDatePath));
		
		for(WebElement elem:departList){
			if(elem.getText().equals("24")){
				elem.click();
				break;
			}
		}
		
		returnDateTextBox.click();
		String retDatePath="//div[@id='ui-datepicker-div']//table//tr//td[@data-month="+splitDate[1]+"][@data-year="+splitDate[2]+"]";
		List<WebElement> returnList=driver.findElements(By.xpath(retDatePath));
		
		for(WebElement elem:returnList){
			if(elem.getText().equals("23")){
				elem.click();
				break;
			}
		}
	}
	
}
