/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

/**
 * @author leonardo.silva
 *
 */
public class SequenceChain extends BaseChain implements Chain {

	@Override
	protected void executeStep(Browser browser, Step step, Context context) {
		step.execute(this, browser.getPage(), context);
	}

}
