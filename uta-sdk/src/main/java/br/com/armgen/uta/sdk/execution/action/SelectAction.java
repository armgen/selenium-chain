/**
 * 
 */
package br.com.armgen.uta.sdk.execution.action;

import br.com.armgen.uta.sdk.element.Page;
import br.com.armgen.uta.sdk.element.SelectableElement;
import br.com.armgen.uta.sdk.element.SelectableElement.SelectionType;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author leonardo.silva
 *
 */
@RequiredArgsConstructor
@Getter
public class SelectAction implements Action{
	
	private final @NonNull SelectableElement element;
	private final @NonNull SelectionType selectionType;
	private final @NonNull String value;

	@Override
	public void execute(Page page) {
		this.element.selectValue(page, this.selectionType, this.value);
	}

}
