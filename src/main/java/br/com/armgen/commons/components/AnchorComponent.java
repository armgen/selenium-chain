/**
 * 
 */
package br.com.armgen.commons.components;

import org.openqa.selenium.WebDriver;

import br.com.armgen.commons.components.Parameters.Parameter;
import br.com.armgen.commons.elements.Link;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author leonardo.silva
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AnchorComponent extends BaseComponents implements Component {

	private final Link link;

	public AnchorComponent(WebDriver driver, Parameter parameter) {
		super(driver);
		this.link = new Link(driver, parameter);
	}

	@Override
	protected void executeInternal(Parameters parameters) {
		this.link.click();
	}
	
}
