/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

/**
 * @author leonardo.silva
 *
 */
public class Chains {
	
	public static Chain sequence(Browser browser) {
		return new SequenceChain(browser);
	}
	
}
