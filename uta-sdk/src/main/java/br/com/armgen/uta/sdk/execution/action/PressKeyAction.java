/**
 * 
 */
package br.com.armgen.uta.sdk.execution.action;

import br.com.armgen.uta.sdk.element.ClickableElement;
import br.com.armgen.uta.sdk.element.Page;
import br.com.armgen.uta.sdk.element.PressableElement;
import br.com.armgen.uta.sdk.execution.action.Action;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author leonardo.silva
 *
 */
@RequiredArgsConstructor
@Getter
public class PressKeyAction implements Action {
	
	private final @NonNull PressableElement element;
	private final PressableElement.Keys key;

	@Override
	public void execute(Page page) {
		this.element.sendKeys(page, key);
	}

}
