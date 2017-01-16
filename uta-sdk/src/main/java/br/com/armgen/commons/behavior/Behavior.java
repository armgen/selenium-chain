/**
 * 
 */
package br.com.armgen.commons.behavior;

import br.com.armgen.uta.sdk.execution.Chain;

/**
 * @author leonardo.silva
 *
 */
public interface Behavior {
	
	public enum Type {
		PRE,

		POST;
	}

	void execute(Chain chain);
	
	Type getType();

	void setType(Type pre);

}
