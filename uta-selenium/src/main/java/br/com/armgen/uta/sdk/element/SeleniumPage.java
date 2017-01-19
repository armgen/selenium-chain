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

import java.util.List;

/**
 * @author leonardo.silva
 *
 */
@Getter
public class SeleniumPage extends Page {
	
	private final WebDriver driver;
	private final Browser browser;

	public SeleniumPage(Browser browser) {
		this(browser, WebDriverUtil.create(browser.getName(), browser.getVersion() , null));
	}
	
	public SeleniumPage(Browser browser, WebDriver driver) {
		this.browser = browser;
		this.driver = driver;
	}
	
	@Override
	public WebElement getElement(Element element) {
		return getDriver().findElement(searchBy(element.getSearchBy(), element.getIdentifier()));
	}

	@Override
	public List<WebElement> getElements(Element element) {
		return getDriver().findElements(searchBy(element.getSearchBy(), element.getIdentifier()));
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

	@Override
	public String getUrl() {
		return this.driver.getCurrentUrl();
	}

}
