/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import br.com.armgen.uta.sdk.element.object.Table;
import br.com.armgen.uta.sdk.element.object.Td;
import br.com.armgen.uta.sdk.element.object.Tr;
import br.com.armgen.uta.sdk.execution.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * @author pedro.folim
 *
 */
public class EnterElement extends Element implements PressableElement {

	/**
	 * @param identifier
	 * @param searchBy
	 */
	public EnterElement(String identifier, By searchBy) {
		super(identifier, searchBy);
	}

	@Override
	public void sendKeys(Page page, Keys key) {
		SeleniumPage seleniumPage = (SeleniumPage) page;
		Actions actions = new Actions(seleniumPage.getDriver());
		if(actions == null) throw new IllegalStateException("Element can not be empty for the enter");
		switch (key) {
			case ENTER:
				actions.sendKeys(org.openqa.selenium.Keys.ENTER);
				break;
			default:
				break;
		}
	}
}
