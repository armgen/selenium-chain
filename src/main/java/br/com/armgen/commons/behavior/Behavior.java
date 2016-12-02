/**
 * 
 */
package br.com.armgen.commons.behavior;

import br.com.armgen.commons.execution.Chain;
import br.com.armgen.commons.execution.Step;

/**
 * @author leonardo.silva
 *
 */
public interface Behavior {
	
	public enum Type {
		PRE,

		POST;
	}

	void execute(Chain chain, Step step);
	
	Type getType();

	void setType(Type pre);

}
