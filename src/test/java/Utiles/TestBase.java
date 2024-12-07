package Utiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {

	public WebDriver driver;
	public WebDriver WebDriverManager() throws IOException {
		
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String url= prop.getProperty("QAurl");
		
		
		if(driver==null) {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();

			}
			if(prop.getProperty("browser").equalsIgnoreCase("edge"))
			{
				EdgeDriver edge = new EdgeDriver();

			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			driver.get(url);
		
		} 	return driver;	

	}
}
