package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.AutoConstant;
import generics.Basepage;
import generics.ExcelLibrary;

public class POMFramework  extends Basepage implements AutoConstant
{
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement firstnameTextfield;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement lastnameTextfield;	
	
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement maleRadioButton;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement rememberMeCheckbox;
	
	@FindBy(xpath="//select[@name='countrycode']")
	private WebElement countrycodeDropDownList;
	
	@FindBy(xpath="(//input[@type='text'])[5]")
	private WebElement mobileTextfield;
	
	public POMFramework(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void submit() throws IOException
	{
		firstnameTextfield.sendKeys(ExcelLibrary.getcellvalue(excel_path, sheet_name, 1, 0));
		lastnameTextfield.sendKeys(ExcelLibrary.getcellvalue(excel_path, sheet_name, 1, 1));
		maleRadioButton.click();
		rememberMeCheckbox.click();
		selectbyvisibletext(countrycodeDropDownList, "+91");
		mobileTextfield.sendKeys(ExcelLibrary.getcellvalue(excel_path, sheet_name, 1, 5));
	}
}

