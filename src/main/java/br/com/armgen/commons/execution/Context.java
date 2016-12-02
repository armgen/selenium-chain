/**
 * 
 */
package br.com.armgen.commons.execution;

import br.com.armgen.commons.components.Parameters;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author leonardo.silva
 *
 */
@Data
@AllArgsConstructor
public class Context {
	
	private Chain chain;
	private Parameters parameters;

}
