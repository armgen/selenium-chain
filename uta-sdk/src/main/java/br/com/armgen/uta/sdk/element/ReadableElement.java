/**
 * 
 */
package br.com.armgen.uta.sdk.element;

/**
 * @author pedro.folim
 *
 */
public interface ReadableElement<T> {

	public T read(Page page, String attributeName);
	public String getText(Page page);
}
