/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.armgen.uta.sdk.WebDriverUtil;
import br.com.armgen.uta.sdk.execution.Browser;
import lombok.Getter;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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
		Wait wait = new FluentWait(driver).withTimeout(15, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement result = (WebElement) wait.until(new Function<WebDriver,WebElement>() {
			@Override
			public WebElement apply(WebDriver o) {
				return getDriver().findElement(searchBy(element.getSearchBy(), element.getIdentifier()));
			}
		});
		return result;
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
