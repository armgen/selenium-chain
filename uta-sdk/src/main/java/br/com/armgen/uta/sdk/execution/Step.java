/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import java.util.LinkedList;
import java.util.List;

import br.com.armgen.commons.behavior.ComponentBehavior;
import br.com.armgen.uta.sdk.element.Page;
import br.com.armgen.uta.sdk.execution.action.Action;
import br.com.armgen.uta.sdk.execution.action.NavigateAction;
import br.com.armgen.uta.sdk.execution.action.SwitchWindowAction;
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

	public void execute(Chain chain, Page page) {
		for (Action action : actions) {
			this.executePreBehaviors(chain);
			action.execute(page);
			this.executePostBehaviors(chain);
		}
	}

	public static Step basic(String name) {
		return new Step(name);
	}
	
	public static Step navigate(String name, String newUrl) {
		return new Step(name).action(new NavigateAction(newUrl));
	}

	public static Step switchPage(String name, String pageTitle) {
		return new Step(name).action(new SwitchWindowAction(pageTitle));
	}
}
