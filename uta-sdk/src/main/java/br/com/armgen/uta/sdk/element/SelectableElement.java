/**
 * 
 */
package br.com.armgen.uta.sdk.element;

/**
 * @author leonardo.silva
 *
 */
public interface SelectableElement {

	public void selectValue(Page page, SelectionType selectionType, String value );
	
	public enum SelectionType {
		/**
		 * Seleciona pelo texto
		 */
		BY_VISIBLE_TEXT,
		/**
		 * Seleciona por indice
		 */
		BY_INDEX,
		/**
		 * Seleciona pelo valor
		 */
		BY_VALUE;
	}
}
