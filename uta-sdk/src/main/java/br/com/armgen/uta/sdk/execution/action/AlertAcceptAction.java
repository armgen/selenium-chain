/**
 * 
 */
package br.com.armgen.uta.sdk.execution.action;

import br.com.armgen.uta.sdk.element.AlertableElement;
import br.com.armgen.uta.sdk.element.Page;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author pedro.folim
 *
 */
@RequiredArgsConstructor
@Getter
public class AlertAcceptAction implements Action {

	private final @NonNull
	AlertableElement element;

	@Override
	public void execute(Page page) {
		element.accept(page);
	}
}
