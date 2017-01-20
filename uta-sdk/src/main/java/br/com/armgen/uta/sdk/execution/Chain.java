/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import br.com.armgen.uta.sdk.element.Page;

/**
 * Interface para a sequencia de passos que será executada.
 * @author leonardo.silva
 *
 */
public interface Chain {

	void start();

	String getId();

	Chain step(Step step);

	/**
	 * Retorna o passo atual
	 */
	Step getCurrentStep();

	Page getCurrentPage();
	
	Browser getBrowser();

	void resetSteps();
	
}
