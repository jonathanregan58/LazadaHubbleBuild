import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import java.awt.Robot as Robot

import java.awt.event.KeyEvent as KeyEvent

import com.kms.katalon.core.webui.common.WebUiCommonHelper

import org.openqa.selenium.JavascriptExecutor

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.By




class Lazada {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User is on Home Page of Lazada")
	def user_is_on_home_page_lazada() {
		println "a"
		WebUI.openBrowser('https://www.lazada.co.id/')

		println "b"
		WebUI.maximizeWindow()
		println "c"
		WebUI.delay(60)
		println "c1"
		WebUI.waitForElementPresent(findTestObject('Lazada/Search textbox'), 300)
		println "c2"
	}



	@When("User searches for {string}")
	def user_searches_for(String string) {
		WebUI.setText(findTestObject('Lazada/Search textbox'), string)
		println "d"
		WebUI.waitForElementPresent(findTestObject('Lazada/Search Popup'), 300)
		WebUI.delay(5)
		WebUI.click(findTestObject('Lazada/Search Button Home'))
		println "e"
	}


	@When("User choose price range between {string} to {string}")
	def user_choose_price_range_between_to(String p1, String p2) {
		println "f"
		WebUI.waitForElementPresent(findTestObject('Lazada/Koin'), 300)
		println "g"
		WebUI.verifyElementPresent(findTestObject('Lazada/Koin'), 300)
		println "h"
		WebUI.scrollToElement(findTestObject('Lazada/Koin'), 300)
		println "i"
		WebUI.click(findTestObject('Lazada/Min textbox'))
		WebUI.setText(findTestObject('Lazada/Min textbox'), p1)

		WebUI.click(findTestObject('Lazada/Max textbox'))
		WebUI.setText(findTestObject('Lazada/Max textbox'), p2)

		WebUI.click(findTestObject('Lazada/Button Price Filter'))
	}

	@When("User choose to sort from lowest to highest")
	def user_choose_to_sort_from_lowest_to_highest() {

		println "Filtering"

		WebUI.waitForElementPresent(findTestObject('Lazada/Filter by Price'), 300)

		WebUI.verifyElementPresent(findTestObject('Lazada/Filter by Price'), 300)

		WebUI.scrollToElement(findTestObject('Lazada/Filter by Price'), 300)


		WebUI.waitForElementPresent(findTestObject('Lazada/Harga Dropdown'), 300)

		WebUI.verifyElementPresent(findTestObject('Lazada/Harga Dropdown'), 300)


		WebUI.click(findTestObject('Lazada/Harga Dropdown'))


		WebUI.sendKeys(findTestObject('Lazada/Pilihan pada Harga Dropdown'), Keys.chord(Keys.DOWN))

		WebUI.sendKeys(findTestObject('Lazada/Pilihan pada Harga Dropdown'), Keys.chord(Keys.ENTER))

		println "Filtering 2"
	}


	@Then("User is able to get item name from page {int} to page {int}")
	def user_is_able_to_get_item_name_from_page_to_page(Integer int1, Integer int2) {
		List<String> myStringList = new ArrayList<>();

		for (int i = int1; i <= int2; i++) {
			println("Angka: " + i)
			String activepagenumber = WebUI.getText(findTestObject('Lazada/Active Page Number'))
			WebUI.waitForElementPresent(findTestObject('Lazada/Product Item'), 120)
			TestObject testObj = findTestObject('Lazada/Product Item')
			List<WebElement> elements = WebUI.findWebElements(testObj, 120)
			int elementCount = elements.size()
			println elementCount
			for (int j = 1; j <= elementCount; j++) {
				// Create a TestObject with a parameterized XPath
				TestObject dynamicTextObject = findTestObject('Lazada/Product', [('index') : j])
				// Interact with the dynamic element
				String elementText = WebUI.getText(dynamicTextObject)
				myStringList.add(elementText);
				println "Text of element ${j} page ${i}: ${elementText}"
				// Or perform other actions like click, set text, etc.
			}
			println myStringList

			WebUI.scrollToElement(findTestObject('Lazada/Product', [('index') : elementCount]), 300)
			if(i < 3) {
				WebUI.click(findTestObject('Lazada/Button Next Page'))
			}
		}
	}
}