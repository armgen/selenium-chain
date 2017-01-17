/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

/**
 * @author leonardo.silva
 *
 */
public class SequenceChain extends BaseChain implements Chain {

	public SequenceChain(Browser browser) {
		super(browser);
	}

	@Override
	protected void executeStep(Chain chain, Step step) {
		step.execute(this, chain.getBrowser().getCurrentPage());
	}

}
