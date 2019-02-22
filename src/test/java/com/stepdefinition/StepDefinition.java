package com.stepdefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import com.baseclass.BaseClass;
import com.pom.Login;
import com.pom.SearchHotel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinition extends BaseClass {
	static WebDriver driver;
	@Given("^User launch  the browser and navigate to application$")
	public void user_launch_the_browser_and_navigate_to_application() throws Throwable {
		driver =  getdriver("chrome");
		getUrl("http://adactin.com/HotelAppBuild2/");
    }

	@When("^User enter the valid username$")
	public void user_enter_the_valid_username() throws Throwable {
		Login l = new Login(driver);
		sendkeys(l.getUser(), "geethavinoth");
	}

	@When("^user enter the valid password$")
	public void user_enter_the_valid_password() throws Throwable {
		Login p = new Login(driver);
		sendkeys(p.getPassword(), "9943269006");
	}

	@When("^User click the login button$")
	public void user_click_the_login_button() throws Throwable {
		Login btn = new Login(driver);
		clicktext(btn.getLoginbutton());
	}

	@Then("^User validate the username displayed in the header$")
	public void user_validate_the_username_displayed_in_the_header() throws Throwable {
		System.out.println("geethavinoth");
	}

	@Then("^User close the browser$")
	public void user_close_the_browser() throws Throwable {
		System.out.println("close the browser");
	}

	

	@When("^user select the location$")
	public void user_select_the_location() throws Throwable {
		SearchHotel x = new SearchHotel(driver);
		DD(x.getLocation(),"Sydney", "value");
		
	}

	@When("^User Select hotel$")
	public void user_Select_hotel() throws Throwable {
		SearchHotel y = new SearchHotel(driver);
        DD(y.getHotel(), "Hotel Creek", "value");
	}

	@When("^User Select room type$")
	public void user_Select_room_type() throws Throwable {
		SearchHotel r = new SearchHotel(driver);
		DD(r.getRoom(), "Standard", "value");

	}

	@When("^User Select no-of-rooms$")
	public void user_Select_no_of_rooms() throws Throwable {
		SearchHotel nr = new SearchHotel(driver);
		DD(nr.getRoomno(), "1", "value");

	}
	@When("^Enter check-in-date$")
	public void enter_check_in_date() throws Throwable {
		SearchHotel ci = new SearchHotel(driver);
		sendText(ci.getCheckin(), "24/02/2019", "value");

	}

	@When("^Enter checkout-date$")
	public void enter_checkout_date() throws Throwable {
		SearchHotel co = new SearchHotel(driver);
		sendText(co.getCheckout(), "22/02/2019", "value");
		}

	@When("^Enter adult room$")
	public void enter_adult_room() throws Throwable {
		SearchHotel a = new SearchHotel(driver);
		DD(a.getAroom(), "2", "value");

	}

	@When("^Enter children room$")
	public void enter_children_room() throws Throwable {
		SearchHotel cr = new SearchHotel(driver);
         DD(cr.getCroom(), "1", "value");
	}

	@When("^Click the search button$")
	public void click_the_search_button() throws Throwable {
		SearchHotel sbtn = new SearchHotel(driver);
        clicktext(sbtn.getSubmitbtn());
	}


	
	@Then("^Verify that systemgives an error saying‘check-in-date shouldnot be later thancheck-out-date’$")
	public void verify_that_systemgives_an_error_saying_check_in_date_shouldnot_be_later_thancheck_out_date() throws Throwable {
		SearchHotel e = new SearchHotel(driver);
    org.junit.Assert.assertEquals(e.getError()," Check-In Date shall be before than Check-Out Date");
      
      System.out.println(e.getError());
	}


}
