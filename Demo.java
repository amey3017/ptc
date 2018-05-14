import java.io.File;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.opera.core.systems.scope.protos.WmProtos.OpenURLArg;


public class Demo1 {

	static WebDriver webDriver = null;
	public void openUrl()
	{
		webDriver.get("http://google.com");
	}
	@Test
	public static void main(String arg[]) throws InterruptedException

	{
		Demo1 demo = new Demo1();
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary binary = new FirefoxBinary(new File("D:\\Users\\amkulkarni\\.radar\\browsers\\windows\\Mozilla\\ptc-firefox310-esr4\\firefox.exe"));
		webDriver = new FirefoxDriver(binary, profile);

		CharSequence FromString[]={"GOI"};
		CharSequence ToString[]={"BOM"};

		webDriver.get("http://www.cleartrip.com");
		WebElement ele = webDriver.findElement(By.id("RoundTrip"));
		ele.click();
		Thread.sleep(2000);
		
		ele= webDriver.findElement(By.xpath("//input[@id='FromTag']"));
		ele.sendKeys(FromString);
		Actions action = new Actions(webDriver);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		
		ele= webDriver.findElement(By.xpath("//input[@id='ToTag']"));
		ele.sendKeys(ToString);
		action = new Actions(webDriver);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		
		
		webDriver.findElement(By.xpath("//div[@class='monthBlock first']//a[normalize-space(text())='7']")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("//div[@class='monthBlock last']//a[.='15']")).click();
		Thread.sleep(2000);
		
		ele = webDriver.findElement(By.xpath("//select[@id='Adults']"));
		Select select = new Select(ele);
		Thread.sleep(2000);
		
		select.selectByValue("4");
		
		webDriver.findElement(By.xpath("//input[@id='SearchBtn']")).click();

		Thread.sleep(7000);
		
		Set<String> a =webDriver.getWindowHandles();
		String b[] = (String[]) a.toArray();
		for(int i=0;i<=a.size();i++)
		{
			//webDriver.switchTo().window(a.);
		}
				}
}
