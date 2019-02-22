@E2E
Feature: Fucntionality module of adactin hotel web page 
   Contains E2E login functionality such as login,check in ,check out and bookings
   Background: Launch the browser
	Given User launch  the browser and navigate to application
   @sce1
   Scenario: Verify the user login the application with valid credentials 
	When User enter the valid username
	 And user enter the valid password
	And User click the login button 
	Then User validate the username displayed in the header 
	And User close the browser 
	@sce2
    Scenario: Launch the adactin hotel webpage 
	When User enter the valid username 
	And user enter the valid password
	And User click the login button 
	 And user select the location 
	And User Select hotel 
	And User Select room type	
	And User Select no-of-rooms
	And Enter check-in-date
	And Enter checkout-date
    And Enter adult room
	And Enter children room
	Then Click the search button
	And Verify that systemgives an error saying‘check-in-date shouldnot be later thancheck-out-date’ 
	
	@sce3
    Scenario Outline: Launch the adactin hotel webpage 
	When User enter the valid username 
	And user enter the valid password
	And User click the login button 
	 And user select the location "<Location>"
	And User Select hotel "<Hotel>"
	And User Select room type"<Room Type>" 	
	And User Select no-of-rooms"<Number of Rooms>"
	And Enter check-in-date"<Check In Date>"
	And Enter checkout-date "<Check out Date>"
    And Enter adult room"<Adult Room>"
	And Enter children room"<Children Room>"
	And Click the search button
	And Click the radio button
	Then click the continue button
	And Verify that systemgives an error saying‘check-in-date shouldnot be later thancheck-out-date’ 
	Examples:
	|Location|Hotel      |Room Type|Number of Rooms|Check In Date|Check out Date|Adult Room|Children Room|
	|Sydney  |Hotel Creek|Standard |1-One          |19/02/2019   |21/02/2019    |1-One     |1-One        | 