package com.actitime.generic;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;
import com.actitime.pom.TaskListPage;

public class BaseClass {
	
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() throws InterruptedException {
		Reporter.log("openbrowser",true);
		driver=new ChromeDriver();
		Thread.sleep(5000);
    	}
	
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("login",true);
		FileLib ob=new FileLib();
		String url=ob.getPropertyData("url");
		String un=ob.getPropertyData("username");
		String pwd=ob.getPropertyData("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pwd);
	}
	
	@AfterMethod
	public void logout() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("logout",true);
		Thread.sleep(5000);
		HomePage h=new HomePage(driver);
		h.selectTask();
		Thread.sleep(400);
		TaskListPage t=new TaskListPage(driver);
		t.selectAddNewBtn();
		Thread.sleep(400);
		t.selectNewCustBtn();
		Thread.sleep(400);
		FileLib ob=new FileLib();
		String name=ob.getExcelData("CreateCustomer", 3, 4);
		String desc=ob.getExcelData("CreateCustomer", 3, 5);
		t.selectEnterCustBtn(name);
		Thread.sleep(400);
		t.selectEnterCustDesc(desc);
		Thread.sleep(400);
		t.selectCustomer();
		Thread.sleep(400);
		t.selectOurCompany();
		Thread.sleep(400);
		t.selectCreateCustomer();
		Thread.sleep(8000);
		h.logout();
	}
	
	@AfterTest
	public void closeBrowser() {
		Reporter.log("closebrowser",true);
	}
	

}
