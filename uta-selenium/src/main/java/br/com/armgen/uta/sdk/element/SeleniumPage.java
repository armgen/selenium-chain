/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.armgen.uta.sdk.WebDriverUtil;
import br.com.armgen.uta.sdk.execution.Browser;
import lombok.Getter;

/**
 * @author leonardo.silva
 *
 */
@Getter
public class SeleniumPage extends Page {
	
	private final WebDriver driver;
	private final Browser browser;

	public SeleniumPage(Browser browser, String url) {
		this(browser, url, WebDriverUtil.create(browser.getName(), browser.getVersion() , null));
	}
	
	public SeleniumPage(Browser browser, String url, WebDriver driver) {
		super(url);
		this.browser = browser;
		this.driver = driver;
	}
	

	public void init() {
		this.getDriver().get(getUrl());
	}
	

	@Override
	public WebElement getElement(Element element) {
		return getDriver().findElement(searchBy(element.getSearchBy(), element.getIdentifier()));
	}
	
	/**
	 * 
	 * @param searchBy
	 * @param identifier
	 * @return
	 */
	private By searchBy(br.com.armgen.uta.sdk.execution.By searchBy, String identifier) {
		switch (searchBy) {
		case ID:
			return By.id(identifier);
		case NAME:
			return By.name(identifier);
		case TAG:
			return By.tagName(identifier);
		case XPATH:
			return By.xpath(identifier);
		default:
			break;
		}
		
		return null;
	}

	@Override
	public Page navigate(String url) {
		this.driver.get(url);
		return this;
	}

}
