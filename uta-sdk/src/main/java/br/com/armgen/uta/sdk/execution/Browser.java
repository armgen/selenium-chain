/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import br.com.armgen.uta.sdk.element.Page;
import lombok.Data;

/**
 * Classe que representa o browser, podendo ser qualquer um.
 * @author leonardo.silva
 *
 */
@Data
public abstract class Browser {

	private String name;
	private String version;
	private String plataform;
	
	public abstract Page getPage();
	
}
