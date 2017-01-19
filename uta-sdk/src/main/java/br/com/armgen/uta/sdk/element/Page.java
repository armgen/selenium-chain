/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import java.util.ArrayList;
import java.util.List;

import br.com.armgen.commons.elements.Form;
import br.com.armgen.commons.elements.Link;
import br.com.armgen.uta.sdk.execution.Browser;
import lombok.Data;
import lombok.NonNull;

/**
 * @author leonardo.silva
 *
 */
@Data
public abstract class Page {
	
	/**
	 * Links encontrados na pagina
	 */
	private final List<Link> links = new ArrayList<Link>();
	/**
	 * Forms encontrados na pagina
	 */
	private final  List<Form> forms = new ArrayList<Form>();

	public abstract Browser getBrowser();
	
	public abstract Object getElement(Element element);

	public abstract List<?> getElements(Element element);

	public abstract Page navigate(String url);

	public abstract String getUrl();
	
}
