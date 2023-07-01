package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BaseClass;

public class TaskListPage extends BaseClass {
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newCustBtn;
	
	@FindBy(xpath="//input[@placeholder='Enter Customer Name' and @class]")
	private WebElement entCustName;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement enCustDesc;
	
	@FindBy(xpath="//div[text()='- Select Customer -']")
	private WebElement slctCust;
	
	@FindBy(xpath="//div[text()='Our company' and @class='itemRow cpItemRow ']")
	private WebElement ourCompany;
	
	@FindBy(xpath="//div[text()='Create Customer']")
	private WebElement createCust;
	
	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void selectAddNewBtn() {
		addNewBtn.click();
	}
	
	public void selectNewCustBtn() {
		newCustBtn.click();
	}
	
	public void selectEnterCustBtn(String name) {
		entCustName.sendKeys(name);
	}
	
	public void selectEnterCustDesc(String desc) {
		enCustDesc.sendKeys(desc);
	}
	
	public void selectCustomer() {
		slctCust.click();
	}
	
	public void selectOurCompany() {
		ourCompany.click();
	}
	
	public void selectCreateCustomer() {
		createCust.click();
	}
	
	

}
