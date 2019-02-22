package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel {
	static WebDriver driver;
	@FindBy(id="location")
	private WebElement location;
	@FindBy(id="hotels")
	private WebElement hotel;
	@FindBy(id="room_type")
	private WebElement room;
	@FindBy(id="room_nos")
	private WebElement roomno;
    @FindBy(xpath="//input[@id='datepick_in']")
	private WebElement checkin;
    @FindBy(id="datepick_out")
	private WebElement checkout;
    @FindBy(id="adult_room")
	private WebElement Aroom;
    @FindBy(id="child_room")
	private WebElement Croom;
    @FindBy(id="Submit")
	private WebElement submitbtn;
   @FindBy(id="checkin_span")
	private WebElement error;
   @FindBy(id="radiobutton_0")
	private WebElement radiobtn;
    @FindBy(id="continue")
	private WebElement btn;
   @FindBy(id="first_name")
	private WebElement fname;
   @FindBy(id="last_name")
	private WebElement lname;
   @FindBy(id="address")
	private WebElement address;
   @FindBy(id="cc_num")
	private WebElement ccnum;
    @FindBy(id="cc_type")
	private WebElement cctype;
    @FindBy(id="cc_exp_month")
	private WebElement month;
    @FindBy(id="cc_exp_year")
	private WebElement year;
    @FindBy(id="cc_cvv")
	private WebElement cvv;
    @FindBy(id="book_now")
	private WebElement booknow;

	public WebElement getRadiobtn() {
		return radiobtn;
	}
	public WebElement getBtn() {
		return btn;
	}
	public WebElement getFname() {
		return fname;
	}
	public WebElement getLname() {
		return lname;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCcnum() {
		return ccnum;
	}
	public WebElement getCctype() {
		return cctype;
	}
	public WebElement getMonth() {
		return month;
	}
	public WebElement getYear() {
		return year;
	}
	public WebElement getCvv() {
		return cvv;
	}
	public WebElement getBooknow() {
		return booknow;
	}
	public WebElement getError() {
	return error;
}
	public static WebDriver getDriver() {
		return driver;
	}
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotel() {
		return hotel;
	}
	public WebElement getRoom() {
		return room;
	}
	public WebElement getRoomno() {
		return roomno;
	}
	public WebElement getCheckin() {
		return checkin;
	}
	public WebElement getCheckout() {
		return checkout;
	}
	public WebElement getAroom() {
		return Aroom;
	}
	public WebElement getCroom() {
		return Croom;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	public SearchHotel(WebDriver Idriver) {
		driver=Idriver;
		PageFactory.initElements(Idriver, this);
		
	}

 
}

