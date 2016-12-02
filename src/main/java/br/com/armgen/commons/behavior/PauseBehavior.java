/**
 * 
 */
package br.com.armgen.commons.behavior;

import br.com.armgen.commons.execution.Chain;
import br.com.armgen.commons.execution.Step;
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
	 * @see br.com.armgen.commons.behavior.Behavior#execute(br.com.armgen.commons.execution.Chain, br.com.armgen.commons.execution.Step)
	 */
	@Override
	public void execute(Chain chain, Step step) {
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
