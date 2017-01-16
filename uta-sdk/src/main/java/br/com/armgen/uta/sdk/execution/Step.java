/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import java.util.LinkedList;
import java.util.List;

import br.com.armgen.commons.behavior.ComponentBehavior;
import br.com.armgen.uta.sdk.element.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Classe que representa o passo que será executado.
 * @author leonardo.silva
 *
 */
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Step extends ComponentBehavior {

	/**
	 * Nome
	 */
	private final @NonNull String name;
	
	/**
	 * Lista de acoes que seram executadas para o passo.
	 */	
	private final List<Action> actions = new LinkedList<>();
	
	public Step action(Action action) {
		this.actions.add(action);
		return this;
	}

	public void execute(Chain chain, Page page, Context context) {
		for (Action action : actions) {
			this.executePreBehaviors(chain);
			action.execute(page, context);
			this.executePostBehaviors(chain);
		}
	}

}
