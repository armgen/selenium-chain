/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import br.com.armgen.uta.sdk.WebDriverUtil;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

import br.com.armgen.uta.sdk.element.Page;
import br.com.armgen.uta.sdk.element.SeleniumPage;

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

		WebDriver driverPopup = null;
		String selectedWindowHandler = null;
		//String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			selectedWindowHandler = iterator.next();

			driverPopup = driver.switchTo().window(selectedWindowHandler);
			if( driverPopup.getTitle().equals(pageTitle) ) {
				break;
			}
		}
		this.setCurrentPage(new SeleniumPage(this, driverPopup));
	}

	@Override
	public void prepare() {
		if(this.getCurrentPage() == null) {
			WebDriver driver = WebDriverUtil.create(this.getName(), this.getVersion(), this.getPlataform());
			this.setCurrentPage(new SeleniumPage(this, driver));
		}
	}


}
