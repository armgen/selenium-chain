/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import java.util.ArrayList;
import java.util.List;

import br.com.armgen.commons.elements.Form;
import br.com.armgen.commons.elements.Link;
import lombok.Data;

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
	
	protected final String url;
	
	public abstract void init();
	
	public abstract Object getElement(Element element);
	
}
