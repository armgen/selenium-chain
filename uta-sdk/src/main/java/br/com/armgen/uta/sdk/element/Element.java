/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import br.com.armgen.uta.sdk.execution.By;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Classe que representa o elemento HTML. Podendo ser um input, select e etc.
 * @author leonardo.silva
 *
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public abstract class Element {

	/**
	 * Identificador do elemento. 
	 * @see By
	 */
	private final String identifier;
	
	/**
	 * Enum que idetifica o tipo do identificador.
	 */
	private final By searchBy;
}
