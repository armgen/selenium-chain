/**
 * 
 */
package br.com.armgen.uta.sdk.execution.action;

import br.com.armgen.uta.sdk.element.ClickableElement;
import br.com.armgen.uta.sdk.element.ClickableRadioElement;
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
public class ClickRadioAction implements Action {
	
	private final @NonNull ClickableRadioElement element;
	private final @NonNull int index;

	@Override
	public void execute(Page page) {
		this.element.click(page,index);
	}

}
