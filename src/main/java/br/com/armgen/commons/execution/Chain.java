/**
 * 
 */
package br.com.armgen.commons.execution;

/**
 * @author leonardo.silva
 *
 */
public interface Chain {

	void start();
	
	String getId();

	void addStep(Step step);
}
