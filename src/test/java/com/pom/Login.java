package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	static WebDriver driver;
@FindBy(id="username")
private WebElement user;
@FindBy(id="password")
private WebElement password;
@FindBy(id="login")
private WebElement loginbutton;
public WebElement getUser() {
	return user;
}
public WebElement getPassword() {
	return password;
}
public WebElement getLoginbutton() {
	return loginbutton;
}

public Login(WebDriver Idriver) {
	driver=Idriver;
	PageFactory.initElements(Idriver, this);
	
}


}
