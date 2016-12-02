/**
 * 
 */
package br.com.armgen.commons.execution;

import br.com.armgen.commons.behavior.Behavior;
import br.com.armgen.commons.behavior.Behavior.Type;
import br.com.armgen.commons.components.Component;
import lombok.Data;

/**
 * @author leonardo.silva
 *
 */
@Data
public class Step {

	private String name;
	private Component component;
	
	public Step(String name, Component component) {
		super();
		this.name = name;
		this.component = component;
	}

	public void execute(Context context) {
		this.component.execute(this, context);
	}

	public void addPreBehavior(Behavior behavior) {
		behavior.setType(Type.PRE);
		this.component.getBehaviors().add(behavior);
	}
	
	public void addPostBehavior(Behavior behavior) {
		behavior.setType(Type.POST);
		this.component.getBehaviors().add(behavior);
	}
	
}
