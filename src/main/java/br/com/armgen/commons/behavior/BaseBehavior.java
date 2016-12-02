/**
 * 
 */
package br.com.armgen.commons.behavior;

import lombok.Data;

/**
 * @author leonardo.silva
 *
 */
@Data
public abstract class BaseBehavior implements Behavior {

	protected Type type = Type.POST;
	protected BehaviorResult result;
}
