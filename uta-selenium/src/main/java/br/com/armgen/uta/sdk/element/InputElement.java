/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import br.com.armgen.uta.sdk.execution.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * @author leonardo.silva
 *
 */
public class InputElement extends Element implements TypableElement, ClickableElement,ClickableRadioElement, ReadableElement<String> {
	
	/**
	 * @param identifier
	 * @param searchBy
	 */
	public InputElement(String identifier, By searchBy) {
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
	public void type(Page page, String value) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		WebElement element = seleniumPage.getElement(this);
		if(element == null) throw new IllegalStateException("Element can not be empty for the type");
		element.clear();
		element.sendKeys(value);
	}

	@Override
	public void typeHidden(Page page, String value) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		WebElement element = seleniumPage.getElement(this);
		if(element == null) throw new IllegalStateException("Element can not be empty for the type");
		//modify field
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) seleniumPage.getDriver()).executeScript(js, element);
		element.clear();
		element.sendKeys(value);
	}

	@Override
	public void select(Page page, String value) {
		//TODO Implementar
	}

	@Override
	public void click(Page page, int index) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		List<WebElement> radios = seleniumPage.getElements(this);
		if(radios == null) throw new IllegalStateException("Element Radio can not be empty for the click");
		radios.get(index-1).click();
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

	@Override
	public void doubleClick(Page page) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		WebElement element = seleniumPage.getElement(this);
		if(element == null) throw new IllegalStateException("Element can not be empty for the double click");
		Actions act = new Actions(seleniumPage.getDriver());
		act.doubleClick(element).build().perform();
	}

}
