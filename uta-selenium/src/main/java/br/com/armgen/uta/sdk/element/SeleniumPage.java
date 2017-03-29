/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.armgen.uta.sdk.WebDriverUtil;
import br.com.armgen.uta.sdk.execution.Browser;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author leonardo.silva
 *
 */
@Getter
public class SeleniumPage extends Page {
	
	private final WebDriver driver;
	private final Browser browser;
	private static final long DEFAULT_TIMEOUT = 5;

	public SeleniumPage(Browser browser) {
		this(browser, WebDriverUtil.create(browser.getName(), browser.getVersion() , null));
	}
	
	public SeleniumPage(Browser browser, WebDriver driver) {
		this.browser = browser;
		this.driver = driver;
	}
	
	@Override
	public WebElement getElement(Element element) {
		Wait waitElement = new FluentWait(driver).withTimeout(15, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		WebElement result = (WebElement) waitElement.until(new Function<WebDriver,WebElement>() {
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
			case CSS_SELECTOR:
				return By.cssSelector(identifier);
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

	private Object executeJS(final String script) {
		return ((JavascriptExecutor) driver).executeScript(script);
	}

	public WebElement waitUntil(final Function<By, ExpectedCondition<WebElement>> condition, Element element) {
		return waitUntil(condition, Optional.<Long>empty(), element);
	}

	public WebElement waitUntil(final Function<By, ExpectedCondition<WebElement>> condition, final Optional<Long> timeout, Element element) {
		try {
			return getWait(timeout).until(condition.apply(searchBy(element.getSearchBy(), element.getIdentifier())));
		} catch (Exception e) {
			throw new AssertionError("Unable to find element by " + element.getSearchBy() + " = \"" + element.getIdentifier() + "\"", e);
		}
	}

	private FluentWait<WebDriver> getWait(final Optional<Long> timeout) {
		return timeout.map(sec -> new WebDriverWait(getDriver(), WebDriverWait.DEFAULT_SLEEP_TIMEOUT).withTimeout(sec, TimeUnit.SECONDS))
				.orElse(new WebDriverWait(getDriver(), WebDriverWait.DEFAULT_SLEEP_TIMEOUT).withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS));
	}
}
