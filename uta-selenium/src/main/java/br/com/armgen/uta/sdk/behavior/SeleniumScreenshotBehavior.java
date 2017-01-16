package br.com.armgen.uta.sdk.behavior;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.com.armgen.commons.behavior.ScreenshotBehavior;
import br.com.armgen.uta.sdk.element.SeleniumPage;
import br.com.armgen.uta.sdk.execution.Chain;

public class SeleniumScreenshotBehavior extends ScreenshotBehavior {

	@Override
	public void saveScreenshot(Chain chain, String nameStep) {
		SeleniumPage seleniumPage = (SeleniumPage) chain.getCurrentPage();
		try {
			new ScreenshotHelper().saveScreenshot(seleniumPage.getDriver(), nameStep);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class ScreenshotHelper {

		public void saveScreenshot(WebDriver driver, String screenshotFileName) throws IOException {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(screenshotFileName));
		}
	}

}
