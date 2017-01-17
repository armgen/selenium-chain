/**
 * 
 */
package br.com.armgen.uta.sdk.execution.action;

import br.com.armgen.uta.sdk.element.Page;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author leonardo.silva
 *
 */
@RequiredArgsConstructor
@Getter
public class NavigateAction implements Action {
	
	private final @NonNull String newUrl;

	@Override
	public void execute(Page page) {
		page.navigate(newUrl);
	}

}
