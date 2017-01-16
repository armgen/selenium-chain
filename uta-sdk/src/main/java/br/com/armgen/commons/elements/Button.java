/**
 * 
 */
package br.com.armgen.commons.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.armgen.commons.components.Parameters.Parameter;
import br.com.armgen.uta.sdk.element.Page;

/**
 * @author leonardo.silva
 *
 */
public class Button implements ClickableElement {
	
	private final Parameter parameter;
	private final WebDriver driver;

	public Button(WebDriver driver, Parameter parameter) {
		this.driver = driver;
		this.parameter = parameter;
		
	}
	
	@Override
	public Page click() {
		WebElement button = driver.findElement(this.parameter.getSearchBy());
		button.click();
		return null;
	}
	
	public String text() {
		return driver.findElement(this.parameter.getSearchBy()).getText();
	}

}
