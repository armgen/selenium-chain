/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.armgen.uta.sdk.WebDriverUtil;
import lombok.Getter;

/**
 * @author leonardo.silva
 *
 */
@Getter
public class SeleniumPage extends Page {
	
	private final WebDriver driver;

	public SeleniumPage(String url) {
		super(url);
		this.driver = WebDriverUtil.create("internet explorer", "8", null);
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

}
