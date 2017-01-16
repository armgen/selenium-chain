/**
 * 
 */
package br.com.armgen.commons.behavior;

import br.com.armgen.uta.sdk.execution.Chain;

/**
 * @author leonardo.silva
 *
 */
public interface IComponentBehavior {

	public void executePreBehaviors(Chain chain);
	public void executePostBehaviors(Chain chain);
}
