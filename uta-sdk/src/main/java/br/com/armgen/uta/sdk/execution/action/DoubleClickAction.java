/**
 * 
 */
package br.com.armgen.uta.sdk.execution.action;

import br.com.armgen.uta.sdk.element.ClickableElement;
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
public class DoubleClickAction implements Action {
	
	private final @NonNull ClickableElement element;

	@Override
	public void execute(Page page) {
		this.element.doubleClick(page);
	}

}
