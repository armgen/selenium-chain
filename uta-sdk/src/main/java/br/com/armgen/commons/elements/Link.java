/**
 * 
 */
package br.com.armgen.commons.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.armgen.commons.components.Parameters.Parameter;
import br.com.armgen.uta.sdk.element.Page;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leonardo.silva
 *
 */
@Data
@Slf4j
public class Link implements ClickableElement {
	
	private final WebDriver driver;
	private final Parameter parameter;

	@Override
	public Page click() {
		WebElement element = driver.findElement(this.parameter.getSearchBy());
		log.info("Click para o element {}", element);
		element.click();
		return getLinkedPage();
	}
	
	public Page getLinkedPage() {
		return null;
	}

	public String text() {
		return driver.findElement(this.parameter.getSearchBy()).getText();
	}

	
}
