/**
 * 
 */
package br.com.armgen.uta.sdk.element;

/**
 * @author leonardo.silva
 *
 */
public interface TypableElement {

	/**
	 * Inputa o valor no campo. 
	 * @param page WebDriver para a implementacao
	 * @param value Valor
	 */
	public void type(Page page, String value);
	
	/**
	 * Seleciona o valor do campo.
	 * @param page WebDriver para a implementacao
	 */
	public void select(Page page);
}
