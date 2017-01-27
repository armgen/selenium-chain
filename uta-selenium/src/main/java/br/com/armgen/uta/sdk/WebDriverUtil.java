/**
 * 
 */
package br.com.armgen.uta.sdk;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import ru.stqa.selenium.factory.WebDriverFactory;

/**
 * @author leonardo.silva
 *
 */
public class WebDriverUtil {

	public static WebDriver create(String browserName, String browserVersion, String browserPlatform) {
		WebDriver driver;
		String bName;
		String bVersion;
		String bPlataform;
		
		if(StringUtils.isBlank(browserName)) {
			bName = "";//PropertyLoader.loadProperty("browser.name");
		} 
		else {
			bName = browserName;
		}
		
		if(StringUtils.isBlank(browserVersion)) {
			bVersion = "";//PropertyLoader.loadProperty("browser.version");
		} 
		else {
			bVersion = browserVersion;
		}
		
		if(StringUtils.isBlank(browserPlatform)) {
			bPlataform = "";//PropertyLoader.loadProperty("browser.platform");
		} 
		else {
			bPlataform = browserPlatform;
		}
		
		
		if( "internet explorer".equals(bName)) {
			InternetExplorerDriverManager.getInstance().setup();
			InternetExplorerDriverManager.getInstance().setup(Architecture.x32);
		} 
		else if ("firefox".equals(bName)) {
			FirefoxDriverManager.getInstance().setup();
		}
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(bName);
		capabilities.setVersion(bVersion);
		if (StringUtils.isNotBlank(bPlataform)) {
			capabilities.setPlatform(Platform.valueOf(bPlataform));
		}
		driver = WebDriverFactory.getDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver create(String browserName) {
		return create(browserName, null, null);
	}

}
