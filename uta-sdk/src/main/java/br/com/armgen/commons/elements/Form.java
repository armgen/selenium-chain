/**
 * 
 */
package br.com.armgen.commons.elements;

import br.com.armgen.uta.sdk.element.Page;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leonardo.silva
 *
 */
@Slf4j
public abstract class Form {

	public Page submit() {
		fill();
		log.info("Submit da pagina");
		getSubmitButton().click();
		return getPageAfterSubmit();
	}

	protected abstract void fill();

	protected abstract Button getSubmitButton();

	protected abstract Page getPageAfterSubmit();

}
