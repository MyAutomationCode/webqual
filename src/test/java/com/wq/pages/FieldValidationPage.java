package com.wq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wq.common.Commons;

public class FieldValidationPage extends Commons{

	public static Boolean getIsEnabledValues(String value) {
		
		Commons.waitTime();
		Boolean result = driver.findElement(By.xpath(prop.getProperty(value))).isEnabled();
		return result;

	}
	public static Boolean getIsSelectedValues(String value) {
		
		Commons.waitTime();
		Boolean result = driver.findElement(By.xpath(prop.getProperty(value))).isSelected();
		return result;

	}


}
