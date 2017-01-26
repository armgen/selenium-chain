/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import br.com.armgen.uta.sdk.execution.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * @author leonardo.silva
 *
 */
public class ButtonElement extends Element implements ClickableElement, ReadableElement<String> {

	/**
	 * @param identifier
	 * @param searchBy
	 */
	public ButtonElement(String identifier, By searchBy) {
		super(identifier, searchBy);
	}

	@Override
	public void click(Page page) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		WebElement element = seleniumPage.getElement(this);
		if(element == null) throw new IllegalStateException("Element can not be empty for the click");
		element.click();
	}

	@Override
	public void doubleClick(Page page) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		WebElement element = seleniumPage.getElement(this);
		if(element == null) throw new IllegalStateException("Element can not be empty for the double click");
		Actions act = new Actions(seleniumPage.getDriver());
		act.doubleClick(element).build().perform();
	}


	@Override
	public String read(Page page, String attributeName) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		WebElement element = seleniumPage.getElement(this);
		if(element == null) throw new IllegalStateException("Element can not be empty for the read");
		return element.getAttribute(attributeName);
	}

	@Override
	public String getText(Page page) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		WebElement element = seleniumPage.getElement(this);
		if(element == null) throw new IllegalStateException("Element can not be empty for the getText");
		return element.getText();
	}
}
