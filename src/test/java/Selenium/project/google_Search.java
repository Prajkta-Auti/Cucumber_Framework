package Selenium.project;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class google_Search {
	@org.testng.annotations.Test
	public  void Test() {
		System.setProperty("webdriver.chrome.driver","C:\\Prajkta\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/broken");
        List<WebElement> images= driver.findElements(By.tagName("img"));
        System.out.println(images.size());
        for(int i=0;i<images.size();i++) {
        	WebElement image = images.get(i);
         String imageURL=image.getAttribute("src");
        	verifyLinks(imageURL);
	}
	}
	public static void verifyLinks(String linkUrl) {
		
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection urlconnect= (HttpURLConnection)url.openConnection();
			urlconnect.setConnectTimeout(5000);
			urlconnect.connect();
			if(urlconnect.getResponseCode()>=400) 
				{
	            	System.out.println(linkUrl+" - "+urlconnect.getResponseMessage()+" is a broken link");
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+urlconnect.getResponseMessage());
	            }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}
