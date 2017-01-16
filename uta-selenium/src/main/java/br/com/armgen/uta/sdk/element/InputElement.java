/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import org.openqa.selenium.WebElement;

import br.com.armgen.uta.sdk.execution.By;

/**
 * @author leonardo.silva
 *
 */
public class InputElement extends Element implements TypableElement, ClickableElement {
	
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
		element.sendKeys(value);
	}

	@Override
	public void select(Page page) {
		//TODO Seleciona o texto do input
	}
	
}
