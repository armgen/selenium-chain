/**
 * 
 */
package br.com.armgen.uta.sdk.element;

/**
 * @author pedro.folim
 *
 */
public interface PressableElement {

	public void sendKeys(Page page, Keys key);

	public enum Keys {
		/**
		 * Pressiona Enter
		 */
		ENTER
	}
}
