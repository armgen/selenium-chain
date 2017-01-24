/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import br.com.armgen.uta.sdk.WebDriverUtil;
import com.google.common.base.Function;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

import br.com.armgen.uta.sdk.element.Page;
import br.com.armgen.uta.sdk.element.SeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 * @author leonardo.silva
 *
 */
public class SeleniumBrowser extends Browser implements Serializable {

	public SeleniumBrowser(){super("","","");}

	public SeleniumBrowser(String name, String version, String plataform) {
		super(name, version, plataform);
	}

	public static Browser basic() {
		return new SeleniumBrowser("internet explorer", "8", "");
	}

	/* (non-Javadoc)
	 * @see br.com.armgen.uta.sdk.execution.Browser#switchTo(java.lang.String)
	 */
	@Override
	public void switchTo(String pageTitle) {
		WebDriver driver = ((SeleniumPage) this.getCurrentPage()).getDriver();

		Wait wait = new FluentWait(driver).withTimeout(15, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoDriverException.class);
		WebDriver result = (WebDriver) wait.until(new Function<WebDriver,WebDriver>() {
			@Override
			public WebDriver apply(WebDriver driver) {

				Set<String> handles = driver.getWindowHandles();
				Iterator<String> iterator = handles.iterator();

				WebDriver driverPopup = null;
				String selectedWindowHandler = null;
				boolean hasPopup = false;
				while (iterator.hasNext()){
					selectedWindowHandler = iterator.next();
					driverPopup = driver.switchTo().window(selectedWindowHandler);
					if( driverPopup.getTitle().equals(pageTitle) ) {
						hasPopup = true;
						break;
					}
				}
				if(!hasPopup)throw new NoDriverException();
				return driverPopup;
			}
		});
		this.setCurrentPage(new SeleniumPage(this, result));
	}

	@Override
	public void prepare() {
		if(this.getCurrentPage() == null) {
			WebDriver driver = WebDriverUtil.create(this.getName(), this.getVersion(), this.getPlataform());
			this.setCurrentPage(new SeleniumPage(this, driver));
		}
	}


}
