/**
 * 
 */
package br.com.armgen.commons.execution;

import br.com.armgen.commons.components.Parameters;

/**
 * @author leonardo.silva
 *
 */
public class SequenceChain extends BaseChain implements Chain {


	public SequenceChain(Parameters parameters) {
		super(parameters);
	}

	@Override
	protected void executeStep(Step step, Context context) {
		step.execute(context);
	}

}
