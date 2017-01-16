/**
 * 
 */
package br.com.armgen.commons.behavior;

import java.util.LinkedList;
import java.util.List;

import br.com.armgen.uta.sdk.execution.Chain;

/**
 * @author leonardo.silva
 *
 */
public class ComponentBehavior implements IComponentBehavior {
	
	private List<Behavior> preBehaviors = new LinkedList<>();
	private List<Behavior> postBehaviors = new LinkedList<>();
	
	
	public ComponentBehavior pre(Behavior behavior) {
		this.preBehaviors.add(behavior);
		return this;
	}
	
	public ComponentBehavior post(Behavior behavior) {
		this.postBehaviors.add(behavior);
		return this;
	}

	/* (non-Javadoc)
	 * @see br.com.armgen.commons.behavior.IComponentBehavior#executePreBehaviors()
	 */
	@Override
	public void executePreBehaviors(Chain chain) {
		for (Behavior behavior : preBehaviors) {
			behavior.execute(chain);
		}
	}

	/* (non-Javadoc)
	 * @see br.com.armgen.commons.behavior.IComponentBehavior#executePostBehaviors()
	 */
	@Override
	public void executePostBehaviors(Chain chain) {
		for (Behavior behavior : postBehaviors) {
			behavior.execute(chain);
		}
	}

}
