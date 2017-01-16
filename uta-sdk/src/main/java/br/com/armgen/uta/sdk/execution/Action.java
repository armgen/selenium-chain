/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import br.com.armgen.uta.sdk.element.Page;

/**
 * @author leonardo.silva
 *
 */
public interface Action {
	
	public void execute(Page page, Context context);
}
