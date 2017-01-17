/**
 * 
 */
package br.com.armgen.uta.sdk.execution.action;

import br.com.armgen.uta.sdk.element.Page;
import br.com.armgen.uta.sdk.element.TypableElement;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author leonardo.silva
 *
 */
@RequiredArgsConstructor
@Getter
public class FillAction implements Action {
	
	private final @NonNull TypableElement element;
	private final @NonNull String value;

	@Override
	public void execute(Page page) {
		this.element.type(page, value);
	}

}
