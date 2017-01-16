/**
 * 
 */
package br.com.armgen.commons.behavior;

import br.com.armgen.uta.sdk.execution.Chain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author leonardo.silva
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PauseBehavior extends BaseBehavior implements Behavior {
	
	private int waitMillisForNextStep = 0;

	/*
	 * (non-Javadoc)
	 * @see br.com.armgen.commons.behavior.Behavior#execute(br.com.armgen.uta.sdk.execution.Chain)
	 */
	@Override
	public void execute(Chain chain) {
		if ( this.waitMillisForNextStep > 0 ) {
			try {
				Thread.sleep( this.waitMillisForNextStep );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		result = new BehaviorResult();
	}

}
