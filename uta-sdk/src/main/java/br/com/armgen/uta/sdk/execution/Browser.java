/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import br.com.armgen.uta.sdk.element.Page;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Classe que representa o browser, podendo ser qualquer um.
 * @author leonardo.silva
 *
 */
@Data
@RequiredArgsConstructor
public abstract class Browser {

	private @NonNull String name;
	private @NonNull String version;
	private @NonNull String plataform;
	
	private Page currentPage;
	
	public Page navigateTo(String url) {
		return this.getCurrentPage().navigate(url);
	}

	public abstract Page switchTo(String pageTitle);

	public abstract void prepare();
	
}
