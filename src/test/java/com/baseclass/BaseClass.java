package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver getdriver(String browserName ) throws Exception{
		try {
			if (browserName == "chrome") {
				System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Workspace\\SeleniumDemo\\Driver\\chromedriver.exe");
				 driver= new ChromeDriver();
				 driver.manage().window().maximize(); 
				 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			}else if (browserName == "IE") {
				System.setProperty("webdriver.chrome.driver", "H:\\Eclipse\\FirstDaySelenium\\Driver\\chromedriver.exe");
				 driver= new ChromeDriver();
			}
				
			}

			catch (Exception e) {
				e.printStackTrace();
					}
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
	}

	// to send Url driver1

	public static void getUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Url is invalid");
		}

	}

	// refresh,back,forward
	public static void navigateback() {
		driver.navigate().back();

	}

	public static void navigateforward() {
		driver.navigate().forward();
	}

	public static void navigaterefresh() {
		driver.navigate().refresh();
	}

	// to get title and url
	public static void title() {
		String title = driver.getTitle();
		System.out.println("Page Title is " + title);
	}

	public static void currenturl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("CurrentUrl is " + currentUrl);
	}

	public static void mouseOver(WebElement element) {

		try {
			Actions ac = new Actions(driver);
			waitForVisiblityofElement(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				ac.moveToElement(element).build().perform();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void elementClear(WebElement element) throws Exception {
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to clear the text in the webelement");
		}
	}

	public static boolean elementIsDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return displayed;

	}

	public static boolean elementIsEnabled(WebElement element) {
		boolean enabled = false;
		try {
			enabled = element.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enabled;

	}

	public static void waitForVisiblityofElement(WebElement element) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 30);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void sendText(WebElement element, String value, String string) throws Exception {
		try {
			waitForVisiblityofElement(element);
			if(elementIsDisplayed(element)&& elementIsEnabled(element)) {
				element.clear();
				element.sendKeys(value);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void clicktext(WebElement element) throws Exception {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("element is not accepting click");

		}

	}
	
	

	
	public static void Screenshot(String fileName) {
		try {
		//	TakesScreenshot ts = (TakesScreenshot) driver;
		//	File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		//	File savefile = new File("H:\\Eclipse\\FirstDaySelenium\\Lib\\ "+ fileName+".png" );
		//	FileUtils.copyFile(screenshotAs, savefile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DD(WebElement element, String value, String options) {
		Select ac = new Select(element);
		if (options.equals("value")) {
			ac.selectByValue(value);
		} else if (options.equals("index")) {
			ac.selectByIndex(Integer.parseInt(value));
		} else if (options.equals("Visibletext")) {
			ac.selectByVisibleText(value);
		}
	}

	public void justclick(WebElement element) throws Exception {
		try {
			Actions ac = new Actions(driver);
			ac.click(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("not reach justclick");
		}

	}

	public void sendkeys(WebElement element, String value) throws Exception {
		try {
			Actions ac = new Actions(driver);
			ac.sendKeys(element, value).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to sendtext");
		}

	}

	public void doubleclick(WebElement element) throws Exception {
		try {
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to make doubleclick");
		}

	}

	public void rightclick(WebElement element) throws Exception {
		try {
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("right click element not wrong");
		}

	}

	public static void dragAndDrop(WebElement source, WebElement target) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to drag and drop");
		}
	}

	public static void waitUntilAlertPresent() throws Exception {
		try {
			WebDriverWait w = new WebDriverWait(driver, 30);
			w.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Alert is not present");
		}
	}

	public static void acceptAlert() throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to accept the alert");
		}
	}

	public static void dismissAlert() throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to dismiss the alert");
		}
	}

	public static void sendKeysToAlert(String value) throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send keys to the alert");
		}
	}

	public static String getText(WebElement element) throws Exception {
		String text;
		try {
			text = element.getText();
			System.out.println(text);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to get the text from the webelement");
		}

		return text;
	}
	public static void toGetInputFromExcel() throws Throwable {

		File f = new File("H:\\Eclipse\\cucumberautomation2\\Book1.xlsx");
		FileInputStream fin = new FileInputStream(f);
	//	Workbook wb = new XSSFWorkbook(fin);
	//	Sheet sheetAt = wb.getSheetAt(0);
		//System.out.println("Number of row " + sheetAt.getPhysicalNumberOfRows());

		//for (int i = 0; i < sheetAt.getPhysicalNumberOfRows(); i++) {
		//	Row row = sheetAt.getRow(i);
//			System.out.println("Row number" + i + " Cell " + row.getPhysicalNumberOfCells());

		//	for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
//			
//				Cell cell = row.getCell(j);
				
				//if (cell.getCellType().equals(CellType.STRING)) {
				
				//	String stringCellValue = cell.getStringCellValue();
					
				//	System.out.println(stringCellValue);
				
			//	} else if (cell.getCellType().equals(CellType.NUMERIC)) {
				
				//	double numericCellValue = cell.getNumericCellValue();
					
			//		long l = (long) numericCellValue;
					
			//		System.out.println(l);
				}
		//	}
	//	}

	//}


	//public static String toGetInputFromExcelandSendText(int row, int cellnum) throws Throwable {
	//String stringCellValue = null ;
	//File f = new File("H:\\Eclipse\\cucumberautomation2\\Book1.xlsx");
	//	FileInputStream fin = new FileInputStream(f);
		
	//	Workbook wb = new XSSFWorkbook(fin);
		
	//	Sheet sheetAt = wb.getSheetAt(0);
		
	//	Cell cell = sheetAt.getRow(row).getCell(cellnum);
		
	//	if (cell.getCellType().equals(CellType.STRING)) {
		
		//	stringCellValue = cell.getStringCellValue();
		
		//} else if (cell.getCellType().equals(CellType.NUMERIC)) {
		
		//	double numericCellValue = cell.getNumericCellValue();
			
		//	long l = (long) numericCellValue;
			
			//stringCellValue = String.valueOf(l);
	//	}
		//	return stringCellValue;
		
		

	//	}

		public static void main(String[] args) throws Throwable {
		toGetInputFromExcel();
	//	String value = toGetInputFromExcelandSendText(1, 3);
	//	System.out.println(value);
	}

		public void getwindowshandle() {
			String cid= driver.getWindowHandle();
			try {
				Set<String> pid= driver.getWindowHandles();
				String y=null;
				for (String x1 : pid) {
					if (!x1.equals(cid)) {
						y=x1;
					}
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		public static void scroll(String option, Object value,int width, int height, WebElement element) throws Exception {
			
			
			if (option.equals("element")) {
				WebElement y=(WebElement)value;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView()",element);
			}else if (option.equals("pixels")) {
				String pixels = (String)value;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("windows.scrollBy(" + width + "," + height + ")");
			}
			

	}




}



