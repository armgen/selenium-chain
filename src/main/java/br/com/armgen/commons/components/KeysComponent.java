/**
 * 
 */
package br.com.armgen.commons.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.armgen.commons.components.Parameters.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leonardo.silva
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class KeysComponent extends BaseComponents implements Component {

	private final Parameter parameter;
	private final String keysToSend;

	public KeysComponent(WebDriver driver, Parameter parameter, String keysToSend) {
		super(driver);
		this.parameter = parameter;
		this.keysToSend = keysToSend;
	}
	
	public KeysComponent(WebDriver driver, String keysToSend) {
		this(driver, null, keysToSend);
	}

	@Override
	protected void executeInternal(Parameters parameters) {
		log.info("Enviando as teclas {}", keysToSend);
		Actions actions = new Actions(getDriver());
		actions.sendKeys(keysToSend);
		actions.build().perform();
	}
	
}
