package com.wq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wq.common.Commons;

public class FieldValidationPage extends Commons{

	public static Boolean validateFields(String value) {

		Boolean result = driver.findElement(By.xpath(prop.getProperty(value))).isEnabled();
		return result;

	}
	public static Boolean validateCheckBox(String value) {

		Boolean result = driver.findElement(By.xpath(prop.getProperty(value))).isSelected();
		return result;

	}


}
