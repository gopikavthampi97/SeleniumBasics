package seleniumBasicCommands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumCommands {
	public WebDriver driver;

	public void testIntialize(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			try {
				throw new Exception("invalid browser");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@BeforeMethod
	public void setUp() {
		testIntialize("firefox");
	}

	@AfterMethod
	public void tearDown() {
		// driver.close();
		// driver.quit();
	}

	@Test
	public void TC_001_verifyObsquraTitle() {

		driver.get("https://selenium.obsqurazone.com/index.php");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Obsqura Testing";
		Assert.assertEquals(actualTitle, expectedTitle, "Invalid title found");
	}

	@Test
	public void TC_002__VerifySingleInput() {
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement messageField = driver.findElement(By.id("single-input-field"));
		WebElement showButton = driver.findElement(By.id("button-one"));
		WebElement message = driver.findElement(By.id("message-one"));
		messageField.sendKeys("Addition");
		showButton.click();
		String expectedMessage = "Your Message : Addition";
		String actualMessage = message.getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid Message Found");
	}

	@Test
	public void TC_003_verifyTwoInputFields() {
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement valueA = driver.findElement(By.id("value-a"));
		WebElement valueB = driver.findElement(By.id("value-b"));
		WebElement getTotalButton = driver.findElement(By.id("button-two"));
		WebElement totalMessage = driver.findElement(By.id("message-two"));
		valueA.sendKeys("5");
		valueB.sendKeys("4");
		getTotalButton.click();
		String actualTotalMessage = totalMessage.getText();
		System.out.println(actualTotalMessage);
		String expectedTotalMessage = "Total A + B : 9";
		Assert.assertEquals(actualTotalMessage, expectedTotalMessage, "Invalid message found");

	}

	@Test
	public void verifyLocators() throws InterruptedException {
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement firstnameField = driver.findElement(By.id("FirstName"));
		WebElement lastnameField = driver.findElement(By.id("LastName"));
		WebElement emailField = driver.findElement(By.id("Email"));
		WebElement passwordField = driver.findElement(By.id("Password"));
		WebElement confirmpasswordField = driver.findElement(By.id("Password"));
		WebElement registerButton = driver.findElement(By.id("register-button"));
		WebElement resultText = driver.findElement(By.className("result"));
		firstnameField.sendKeys("Gopika");
		lastnameField.sendKeys("V Thampi");
		emailField.sendKeys("gopikavasantham773@gmail");
		passwordField.sendKeys("test@123");
		confirmpasswordField.sendKeys("test@123");
		registerButton.click();
		Thread.sleep(3000);
		String actualText = resultText.getText();
		System.out.println(actualText);
		String expectedText = "Your registration completed";
		Assert.assertEquals(actualText, expectedText, "Invalid Text Found");

	}

	@Test
	public void TC_005_verifyDemoLoginPage() throws InterruptedException {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.className("ico-login"));
		loginLink.click();
		WebElement emailField = driver.findElement(By.name("Email"));
		WebElement passwordField = driver.findElement(By.name("Password"));
		emailField.sendKeys("gopikavasantham77@gmail.com");
		passwordField.sendKeys("test@123");
		// WebElement
		// loginButton=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		WebElement loginButton = driver.findElement(By.cssSelector(
				"body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
		loginButton.click();
		Thread.sleep(3000);

	}

	@Test
	public void TC_006_verifyNewToursRegistration() {
		driver.get("https://demo.guru99.com/test/newtours/");
		WebElement registerLink = driver.findElement(By.linkText("REGISTER"));
		// WebElement registerLink=driver.findElement(By.partialLinkText("REGIS"));
		registerLink.click();
		WebElement firstnameField = driver.findElement(By.name("firstName"));
		WebElement lastnameField = driver.findElement(By.name("lastName"));
		WebElement phonenoField = driver.findElement(By.name("phone"));
		WebElement emailField = driver.findElement(By.name("userName"));
		firstnameField.sendKeys("Gopika");
		lastnameField.sendKeys("Thampi");
		phonenoField.sendKeys("9447673884");
		emailField.sendKeys("gopikavasantham77@gmail.com");
		WebElement addressField = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input"));
		WebElement cityField = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input"));
		WebElement stateField = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input"));
		WebElement postalcodeField = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input"));
		addressField.sendKeys("TC/01 Pattom");
		cityField.sendKeys("Trivandrum");
		stateField.sendKeys("Kerala");
		postalcodeField.sendKeys("695584");
		WebElement usernameField = driver.findElement(By.cssSelector("#email"));
		WebElement passwordField = driver.findElement(By.cssSelector(
				"body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(14) > td:nth-child(2) > input[type=password]"));
		WebElement confirmPasswordField = driver.findElement(By.cssSelector(
				"body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(15) > td:nth-child(1) > font > b"));
		usernameField.sendKeys("gopikavasantham77@gmail.com");
		passwordField.sendKeys("test@123");
		confirmPasswordField.sendKeys("test@123");
		WebElement submitField = driver.findElement(By.name("submit"));
		submitField.click();
	}

	@Test
	public void TC_007_verifyEmptyfieldValidation() {
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		WebElement firstnameFieldValidation = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		String actualFirstnameFieldValidation = firstnameFieldValidation.getText();
		System.out.println(actualFirstnameFieldValidation);
		String expectedfirstnameFieldValidation = "Please enter First name.";
		Assert.assertEquals(expectedfirstnameFieldValidation, actualFirstnameFieldValidation, "Invalid Field Found");

		WebElement lastnameFieldValidation = driver.findElement(By.xpath("////input[@id='validationCustom02']]"));
		String actuallastnameFieldValidation = lastnameFieldValidation.getText();
		System.out.println(actuallastnameFieldValidation);
		String expectedlastnameFieldValidation = "Please enter last name.";
		Assert.assertEquals(expectedlastnameFieldValidation, actuallastnameFieldValidation, "Invalid Field Found");

		WebElement usernameFieldValidation = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		String actualusernameFieldValidation = usernameFieldValidation.getText();
		System.out.println(actualusernameFieldValidation);
		String expectedusernameFieldValidation = "Please choose a username.";
		Assert.assertEquals(expectedusernameFieldValidation, actualusernameFieldValidation, "Invalid Field Found");

		WebElement cityFieldValidation = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		String actualcityFieldValidation = cityFieldValidation.getText();
		System.out.println(actualcityFieldValidation);
		String expectedcityFieldValidation = "Please provide a valid city.";
		Assert.assertEquals(expectedcityFieldValidation, actualcityFieldValidation, "Invalid Field Found");

		WebElement stateFieldValidation = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		String actualstateFieldValidation = stateFieldValidation.getText();
		System.out.println(stateFieldValidation);
		String expectedstateFieldValidation = "Please provide a valid state.";
		Assert.assertEquals(expectedstateFieldValidation, actualstateFieldValidation, "Invalid Field Found");

		WebElement zipFieldValidation = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		String actualzipFieldValidation = zipFieldValidation.getText();
		System.out.println(actualzipFieldValidation);
		String expectedzipFieldValidation = "Please provide a valid zip.";
		Assert.assertEquals(expectedzipFieldValidation, actualzipFieldValidation, "Invalid Field Found");

		WebElement submitFieldButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submitFieldButton.click();
	}

	@Test

	public void TC_008_verifyEmptyStateAndZipcode() {
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		WebElement firstnameField = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		WebElement lastnameField = driver.findElement(By.xpath("////input[@id='validationCustom02']]"));
		WebElement usernameField = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		WebElement cityField = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		WebElement submitFieldButton1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));

		firstnameField.sendKeys("Gopika");
		lastnameField.sendKeys("Thampi");
		usernameField.sendKeys("gopika@123");
		cityField.sendKeys("Trivandrum");
		checkBox.click();
		submitFieldButton1.click();
		WebElement stateFieldValidation = driver
				.findElement(By.xpath("//input[@id='validationCustom04']//following-sibling::div[1]"));
		WebElement zipcodeFieldValidation = driver
				.findElement(By.xpath("//input[@id='validationCustom05']//following-sibling::div[1]]"));

		String actualStatename = stateFieldValidation.getText();
		String actualZipMessage = zipcodeFieldValidation.getText();

		String expectedStatename = "Please provide a valid state.";
		String expectedZipMessage = "Please provide a valid zip.";

		Assert.assertEquals(expectedStatename, actualStatename, "Invalid state name found");
		Assert.assertEquals(expectedZipMessage, actualZipMessage, "Invalid state zipcode found");

	}

	@Test
	public void TC_009_verifyFormWithValidation() throws InterruptedException {
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		WebElement firstNameField = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		WebElement lastNameField = driver.findElement(By.xpath("//input[@id='validationCustom02"));
		WebElement usernameField = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		WebElement cityField = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		WebElement stateField = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		WebElement zipField = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		WebElement message = driver.findElement(By.xpath("//div[@id='message-one']"));
		firstNameField.sendKeys("Gopika");
		lastNameField.sendKeys("Thampi");
		usernameField.sendKeys("gopika@123");
		cityField.sendKeys("Trivandrum");
		stateField.sendKeys("Kerala");
		zipField.sendKeys("695584");
		checkBox.click();
		submitButton.click();
		Thread.sleep(3000);
		String actualMessage = message.getText();
		String expectedMessage = ("Form has been submitted successfully!");
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid message ");

	}

	@Test
	public void TC_009_verifyNewsLetterSubscriptionCssSelector() {
		driver.get("https://demowebshop.tricentis.com");
		WebElement emailField = driver.findElement(By.cssSelector("input#newsletter-email"));
		WebElement subscriptionButton = driver.findElement(By.cssSelector("input#newsletter-subscribe-button"));
		emailField.sendKeys("gopika77@gmail.com");
		subscriptionButton.click();

	}

	@Test
	public void TC_010_verifyQuitandClose() {
		driver.get("https://demo.guru99.com/popup.php");
		WebElement clicklink = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clicklink.click();
	}

	@Test
	public void TC_011_verify() {
		driver.get("https://phptravels.com/demo/");
		WebElement firstNameField = driver.findElement(By.cssSelector("input[class='first_name input mb1']"));
		WebElement lastNameField = driver.findElement(By.cssSelector("input[class='last_name input mb1']"));
		WebElement businessNameField = driver.findElement(By.cssSelector("h2[class='cw mw100']"));
		WebElement emailField = driver.findElement(By.cssSelector("input[class='email input mb1']"));
		WebElement numberField1 = driver.findElement(By.cssSelector("span[id='numb1']"));
		WebElement numberField2 = driver.findElement(By.cssSelector("span[id='numb2']"));
		WebElement resultField = driver.findElement(By.cssSelector("input[id='number']"));
		WebElement submitButton = driver.findElement(By.cssSelector("button[id='demo']"));
		WebElement completedBox = driver.findElement(By.cssSelector("div[class='completed']"));
		firstNameField.sendKeys("Gopika");
		lastNameField.sendKeys("Thampi");
		businessNameField.sendKeys("Obsqura");
		emailField.sendKeys("gopika@123");
		String number1 = numberField1.getText();
		String number2 = numberField2.getText();
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);
		int add = num1 + num2;
		String result = String.valueOf(add);
		resultField.sendKeys(result);
		submitButton.click();
		completedBox.isDisplayed();
	}

	@Test
	public void TC_012_verifyNavigateTo() {
		driver.navigate().to("https://demowebshop.tricentis.com/");

	}

	@Test
	public void TC_013_verifyRefresh() {

		driver.get("https://demowebshop.tricentis.com/");
		WebElement emailField = driver.findElement(By.xpath("//input[@id='newsletter-email']"));
		emailField.sendKeys("gopika123@gmail.com");
		driver.navigate().refresh();
	}

	@Test
	public void TC_013_verifyForwardandBackward() throws InterruptedException {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginMenu = driver.findElement(By.xpath("//a[text()='Log in']"));
		loginMenu.click();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
	}

	@Test
	public void TC_014_verifyWebElementCommands() throws InterruptedException {

		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		WebElement subjectField = driver.findElement(By.xpath("//input[@id='subject']"));
		WebElement descriptionField = driver.findElement(By.xpath("//textarea[@id='description']"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		subjectField.sendKeys("Selenium");
		descriptionField.sendKeys("Automation Testing");
		subjectField.clear();
		String classAttributeValue = subjectField.getAttribute("class");
		System.out.println("text--------------" + classAttributeValue);
		String tagnameValue = subjectField.getTagName();
		System.out.println("text-------------" + tagnameValue);
		subjectField.sendKeys("Selenium Testing");
		submitButton.click();
		Thread.sleep(10000);
		WebElement validationMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		String actualValidationMessage = validationMessage.getText();
		String expectedValidationMessage = "Form has been submitted successfully!";
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage, "Invalid Message");
	}

	@Test
	public void TC_015_verifyDisplayed() {
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		WebElement subjectField = driver.findElement(By.xpath("//input[@id='subject']"));
		subjectField.sendKeys("Selenium");
		boolean status = subjectField.isDisplayed();
		System.out.println("status-------" + status);
		Assert.assertTrue(status, "Subject field is not displayed");
	}

	@Test
	public void TC_016_verifyIsSelected() {
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement singleDemoCheckbox = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		boolean statusBeforeClick = singleDemoCheckbox.isSelected();
		System.out.println("status---------" + statusBeforeClick);
		Assert.assertFalse(statusBeforeClick, "Checkbox is checked");
		singleDemoCheckbox.click();
		boolean statusAfterClick = singleDemoCheckbox.isSelected();
		System.out.println("Status----------" + statusAfterClick);
		Assert.assertTrue(statusAfterClick, "Checkbox is not checked");
	}

	@Test
	public void TC_017_verifyIsEnabled() {
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		boolean status = submitButton.isEnabled();
		System.out.println("Status--------" + status);
		Assert.assertTrue(status, "Submit button is not enabled");
		Point point = submitButton.getLocation();
		System.out.println(point.x + "," + point.y);
		Dimension dim = submitButton.getSize();
		System.out.println(dim.height + "," + dim.width);
		String backGroundColor = submitButton.getCssValue("background-color");
		System.out.println(backGroundColor);
		WebElement inputElement = driver.findElement(By.tagName("input"));
		System.out.println(inputElement);
		List<WebElement> elements = driver.findElements(By.tagName("input"));
		System.out.println(elements);
		submitButton.click();
	}

	@Test
	public void TC_018_verifyTheMessageDisplayedInNewTab() {
		driver.get("https://demoqa.com/browser-windows");
		WebElement newTabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
		boolean newTabButtonStatus = newTabButton.isEnabled();
		Assert.assertTrue(newTabButtonStatus, "button is not enabled");
		newTabButton.click();
		driver.navigate().to("https://demoqa.com/browser-windows");
		WebElement samplePage = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		String actualMessage = samplePage.getText();
		String expectedMessage = "This is a sample page";
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid Message found");
	}

	@Test
	public void Tc_019_verifyTheMessageDisplayedInNewWindow() {
		driver.get("https://demoqa.com/browser-windows");
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window ID" + parentWindow);
		WebElement newWindowButton = driver.findElement(By.xpath("//button[@id='windowButton']"));
		newWindowButton.click();
		Set<String> handles = driver.getWindowHandles();// to handle all windowS
		System.out.println(" windows id" + handles);
		Iterator<String> handleIds = handles.iterator();
		while (handleIds.hasNext()) {
			String childWindow = handleIds.next();
			if (!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow);
				WebElement sampleHeading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
				String actualText = sampleHeading.getText();
				String expectedText = "This is a sample page";
				Assert.assertEquals(actualText, expectedText, "Invalid heading found");
				driver.close();

			}
		}
		driver.switchTo().window(parentWindow);
	}

	@Test
	public void TC_0111_verify() {
		driver.get("https://demoqa.com/browser-windows");
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window id" + parentWindow);
		WebElement newWindowMessage = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
		newWindowMessage.click();
		Set<String> childHandles = driver.getWindowHandles();
		System.out.println("windows id" + childHandles);
		Iterator<String> handleIds = childHandles.iterator();
		while (handleIds.hasNext())// checking next handleId is here.One is parent and other is child.If hasNext()
									// is true it has childwindow
		{
			String childWindow = handleIds.next();
			if (!childWindow.equals(parentWindow))
				;
			{
				driver.switchTo().window(childWindow);// control driver is on childWindow
				WebElement sampleMessage = driver.findElement(By.xpath("\"//h1[@id='sampleHeading']"));
				String actualText = sampleMessage.getText();
				String expectedText = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
				Assert.assertEquals(actualText, expectedText, "invalid message found");
				driver.close();
			}
		}

		driver.switchTo().window(parentWindow);
	}

	@Test
	public void TC_020_verifySimpleAlert() {
		driver.get("https:selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickButton = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clickButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
	}

	@Test
	public void TC_021_verifyConfirmAlert() {
		driver.get("https:selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickButton = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clickButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.dismiss();
	}

	@Test
	public void TC_022_verifyPromptAlert() throws InterruptedException {
		driver.get("https:selenium.obsqurazone.com/javascript-alert.php");
		WebElement promptBox = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		promptBox.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.sendKeys("alert-prompt");
		alert.accept();
	}

	@Test

	public void TC_024_verifyRightClick() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClickMe = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action = new Actions(driver);
		action.contextClick(rightClickMe).build().perform();
		// action.build().perform();
	}

	@Test
	public void TC_025_verifyRightClick() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClickMe = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions action = new Actions(driver);
		action.doubleClick(rightClickMe).build().perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test
	public void TC_026_verifyMouseHover() {
		driver.get("https://demoqa.com/menu/");
		WebElement mainItemOne = driver.findElement(By.xpath("//a[text()='Main Item 1']"));
		Actions action = new Actions(driver);
		action.moveToElement(mainItemOne).build().perform();
		// action.moveToElement(mainItemOne,50,50).build().perform();
		// action.moveByOffset(40,50).build().perform();
	}

	@Test

	public void TC_027_verifyDragAndDrop() {
		driver.get("\"https://demoqa.com/droppable");
		WebElement dragmeButton = driver.findElement(By.id("draggable"));
		WebElement drophereButton = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(dragmeButton, drophereButton).build().perform();
	}

	@Test
	public void TC_028_verifyDragAndDropByOffset() {
		driver.get("\"https://demoqa.com/dragabble");
		WebElement dragMeBox = driver.findElement(By.xpath("//div[@id='dragBox']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(dragMeBox, 100, 100).build().perform();
	}

	@Test
	public void TC_029_verifyDragandrop() {
		driver.get("https://selenium.obsqurazone.com/drag-drop.php");
		WebElement draggableOne = driver.findElement(By.xpath("//span[text()='Draggable n°1']"));
		WebElement draggableTwo = driver.findElement(By.xpath("//span[text()='Draggable n°2']"));
		WebElement draggableThree = driver.findElement(By.xpath("//span[text()='Draggable n°3']"));
		WebElement draggableFour = driver.findElement(By.xpath("//span[text()='Draggable n°4']"));
		WebElement droppedItems = driver.findElement(By.xpath("//div[@id='mydropzone']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggableOne, droppedItems).build().perform();
		action.dragAndDrop(draggableTwo, droppedItems).build().perform();
		action.dragAndDrop(draggableThree, droppedItems).build().perform();
		action.dragAndDrop(draggableFour, droppedItems).build().perform();

	}

	@Test
	public void verifyClickHoldAndResize() {
		driver.get("https://demoqa.com/resizable");
		WebElement resizeBox = driver.findElement(By.xpath("//div[@id='resizableBoxWithRestriction']"));
		Actions action = new Actions(driver);
		action.clickAndHold(resizeBox).build().perform();
		action.dragAndDropBy(resizeBox, 75, 75).build().perform();
	}

	@Test
	public void verifyvaluesInDropDown() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropMenu = driver.findElement(By.xpath("//select[@name='country']"));
		List<String> expDropDownList = new ArrayList<String>();
		expDropDownList.add("ALBANIA");
		expDropDownList.add("ALGERIA");
		expDropDownList.add("AMERICAN SAMOA");
		expDropDownList.add("ANDORRA");

		List<String> actDropDownList = new ArrayList<String>();
		Select select = new Select(countryDropMenu);
		List<WebElement> dropDownOptions = select.getOptions();
		for (int i = 0; i < 4; i++) {
			actDropDownList.add(dropDownOptions.get(i).getText());

		}
		System.out.println(actDropDownList);
		Assert.assertEquals(actDropDownList, expDropDownList, "Invalid dropDown option");
		select.selectByVisibleText("INDIA");
		// select.SelectByIndex(23);
		// select.selectByValue("ICELAND");
	}

	@Test
	public void verifyValuesInDropDown1() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropMenu = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countryDropMenu);
		select.selectByVisibleText("INDIA");

	}
}
