/**
 * 
 */
package br.com.armgen.commons.behavior;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import br.com.armgen.uta.sdk.execution.Chain;
import br.com.armgen.uta.sdk.execution.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author leonardo.silva
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class ScreenshotBehavior extends BaseBehavior implements Behavior {

	private final String NAME_FORMAT = "%s-%s-%s.png";
	private String name;

	/*
	 * (non-Javadoc)
	 * @see br.com.armgen.commons.behavior.Behavior#execute(br.com.armgen.uta.sdk.execution.Chain)
	 */
	@Override
	public void execute(Chain chain) {
		Step step = chain.getCurrentStep();
		saveScreenshot(chain, getNameStep(chain, step));
		this.result = new BehaviorResult();
	}

	public abstract void saveScreenshot(Chain chain, String nameStep);

	public String getNameStep(Chain chain, Step step) {
		if( StringUtils.isNotBlank(this.getName())) {
			return this.getName();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		return String.format(NAME_FORMAT, sdf.format(new Date()), chain.getId(), step.getName());
	}
	
}
