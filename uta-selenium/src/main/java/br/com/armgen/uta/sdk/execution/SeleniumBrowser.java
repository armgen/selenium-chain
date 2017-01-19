/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import java.util.Iterator;
import java.util.Set;

import br.com.armgen.uta.sdk.WebDriverUtil;
import org.openqa.selenium.WebDriver;

import br.com.armgen.uta.sdk.element.Page;
import br.com.armgen.uta.sdk.element.SeleniumPage;

/**
 * @author leonardo.silva
 *
 */
public class SeleniumBrowser extends Browser {

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
	public Page switchTo(String pageTitle) {
		WebDriver driver = ((SeleniumPage) this.getCurrentPage()).getDriver();
		
		String selectedWindowHandler = null;
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			String subWindowHandler = iterator.next();
//			if( subWindowHandler.equals(pageTitle) ) {
				selectedWindowHandler = subWindowHandler;
//			}
		}
		WebDriver driverPopup = driver.switchTo().window(selectedWindowHandler);
		return new SeleniumPage(this, driverPopup);
	}

	@Override
	public void prepare() {
		WebDriver driver = WebDriverUtil.create(this.getName(), this.getVersion(), this.getPlataform());
		if(this.getCurrentPage() == null) {
			this.setCurrentPage(new SeleniumPage(this, driver));
		}
	}


}
