/**
 * 
 */
package br.com.armgen.commons.components;

import java.util.List;

import org.openqa.selenium.WebDriver;

import br.com.armgen.commons.behavior.Behavior;
import br.com.armgen.commons.execution.Context;
import br.com.armgen.commons.execution.Step;

/**
 * @author leonardo.silva
 *
 */
public interface Component {

	WebDriver getDriver();
	
	List<Behavior> getBehaviors();

	void execute(Step step, Context context);
	
}
