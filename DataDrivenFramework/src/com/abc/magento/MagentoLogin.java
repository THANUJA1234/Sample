package com.abc.magento;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MagentoLogin {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\HP ENVY\\Desktop\\Vemu\\DataDrivenFramework\\src\\com\\abc\\utilities\\DataDriven.properties");
        Properties p = new Properties(); 
        p.load(fis);
        
        String nurl = p.getProperty("url");
        String nemail = p.getProperty("email");
		String npassword = p.getProperty("password");
		 
		System.out.println(nurl);
	    System.out.println(nemail);
		System.out.println(npassword);
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(nurl);
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.id("email")).sendKeys(nemail);
		driver.findElement(By.id("pass")).sendKeys(npassword);
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
	}

}
