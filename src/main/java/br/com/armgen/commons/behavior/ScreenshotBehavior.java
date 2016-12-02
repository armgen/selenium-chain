/**
 * 
 */
package br.com.armgen.commons.behavior;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.com.armgen.commons.execution.Chain;
import br.com.armgen.commons.execution.Step;
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
public class ScreenshotBehavior extends BaseBehavior implements Behavior {
	
	private final String NAME_FORMAT = "%s-%s-%s.png";
	private String name;
	
	@Override
	public void execute(Chain chain, Step step) {
			try {
				new ScreenshotHelper().saveScreenshot(step.getComponent().getDriver(), getNameStep(chain, step));
			} catch (IOException e) {
				e.printStackTrace();
			}
		this.result = new BehaviorResult();
	}
	
	public String getNameStep(Chain chain, Step step) {
		if( StringUtils.isNotBlank(this.getName())) {
			return this.getName();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		return String.format(NAME_FORMAT, sdf.format(new Date()), chain.getId(), step.getName());
	}

	private class ScreenshotHelper {

		public void saveScreenshot(WebDriver driver, String screenshotFileName) throws IOException {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(screenshotFileName));
		}
	}
}
