/**
 * 
 */
package br.com.armgen.commons.components;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import br.com.armgen.commons.behavior.Behavior;
import br.com.armgen.commons.behavior.Behavior.Type;
import br.com.armgen.commons.execution.Step;
import br.com.armgen.uta.sdk.execution.Context;
import lombok.Data;

/**
 * @author leonardo.silva
 *
 */
@Data
public abstract class BaseComponents implements Component {

	private final List<Behavior> behaviors = new LinkedList<Behavior>();
	private final WebDriver driver;
	
	private void runPostBehaviors(Step step, Context context) {
		this.runBehaviorsByType(Type.POST, step, context);
	}

	private void runPreBehaviors(Step step, Context context) {
		this.runBehaviorsByType(Type.PRE, step, context);
	}
	
	private void runBehaviorsByType(Type type, Step step, Context context) {
		for (Behavior behavior : behaviors) {
			if( type.equals(behavior.getType()) ) {
				behavior.execute(context.getChain(), step);
			}
		}
	}

	@Override
	public void execute(Step step, Context context) {
		this.runPreBehaviors(step, context);
		this.executeInternal(context.getParameters());
		this.runPostBehaviors(step, context);
	}
	
	@Override
	public WebDriver getDriver() {
		return this.driver;
	}

	protected abstract void executeInternal(Parameters parameters);

}
