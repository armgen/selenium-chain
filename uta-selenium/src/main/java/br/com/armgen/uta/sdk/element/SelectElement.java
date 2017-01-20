/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import org.apache.commons.collections.map.LinkedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.armgen.uta.sdk.execution.By;

import java.util.*;

/**
 * @author leonardo.silva
 *
 */
public class SelectElement extends Element implements SelectableElement, ClickableElement, ReadableElement<Map<String,String>> {

	/**
	 * 
	 * @param identifier
	 * @param searchBy
	 */
	public SelectElement(String identifier, By searchBy) {
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
	public void selectValue(Page page, SelectionType selectionType, String value) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		WebElement element = seleniumPage.getElement(this);
		if(element == null) throw new IllegalStateException("Element can not be empty for the select");
		Select select = new Select(element);
		switch (selectionType) {
		case BY_VISIBLE_TEXT:
			select.selectByVisibleText(value);
			break;
		case BY_INDEX:
			select.selectByIndex(Integer.valueOf(value));
			break;
		case BY_VALUE:
			select.selectByValue(value);
			break;
		default:
			break;
		}
	}

	@Override
	public Map<String, String> read(Page page, String attributeName) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		WebElement element = seleniumPage.getElement(this);
		if(element == null) throw new IllegalStateException("element can not be empty for the select");
		Select select = new Select(element);
		Map<String, String> options = new LinkedHashMap<>();
		for(WebElement option : select.getOptions()){
			options.put(option.getAttribute("value"), option.getText());
		}
		return options;
	}

	@Override
	public String getText(Page page) {
		//TODO Implementar
		return null;
	}
}
