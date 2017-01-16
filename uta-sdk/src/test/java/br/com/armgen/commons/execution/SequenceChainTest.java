/**
 * 
 */
package br.com.armgen.commons.execution;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.armgen.commons.behavior.PauseBehavior;
import br.com.armgen.commons.behavior.ScreenshotBehavior;
import br.com.armgen.commons.components.KeysComponent;
import br.com.armgen.commons.components.LoginComponent;
import br.com.armgen.commons.components.Parameters;
import br.com.armgen.commons.components.Parameters.Parameter;
import br.com.armgen.uta.sdk.WebDriverUtil;
import br.com.armgen.uta.sdk.execution.Chain;
import br.com.armgen.uta.sdk.execution.SequenceChain;

/**
 * @author leonardo.silva
 *
 */
public class SequenceChainTest {

	@Test
	public void testLogin() throws Exception {
		
		WebDriver driver = WebDriverUtil.create("internet explorer", "8", null);
//		String url = "https://siebelqa.multiplusfidelidade.com.br/loyalty_ptb/start.swe?SWECmd=Login&SWEPL=1&SWETS=";
		String url = "http://siebelti.multiplusfidelidade.com.br/loyalty_ptb/start.swe?SWECmd=Start&SWEHo=siebelti.multiplusfidelidade.com.br";
		
		Parameters parameters = new Parameters();
//		parameters.addParameter("username", new Parameter("SWEUserName", "CALLCENTER1").searchBy(By.name("SWEUserName")) );
//		parameters.addParameter("password", new Parameter("SWEPassword", "callcenter1234#").searchBy(By.name("SWEUserName")) );
//		parameters.addParameter("submit", new Parameter("s_swepi_22", null).searchBy(By.id("s_swepi_22")));
		
		parameters.addParameter("username", new Parameter("SWEUserName", "CALLCENTER1").searchBy(By.name("SWEUserName")) );
		parameters.addParameter("password", new Parameter("SWEPassword", "callcenter1234#").searchBy(By.name("SWEPassword")) );
		parameters.addParameter("submit", "s_swepi_22");
		
		
		//Cadeia para execução
		Chain chain = new SequenceChain(parameters);
		
		Step login = new Step("Login in Siebel", new LoginComponent(driver, url, parameters));
		login.addPreBehavior(new ScreenshotBehavior());
		login.addPostBehavior(new ScreenshotBehavior());
		login.addPostBehavior(new PauseBehavior(5000));
		chain.addStep(login);
		
		Step goToSiteMaps = new Step("Go to SiteMpas", 
				new KeysComponent(driver, Keys.chord(Keys.LEFT_CONTROL, Keys.LEFT_SHIFT, "a")));
		goToSiteMaps.addPostBehavior(new PauseBehavior(5000));
		chain.addStep(goToSiteMaps);
		
//		Step goToClientes = new Step("Go to Clientes de fidelidade", new AnchorComponent(driver, new Parameter("s_a_1")));
//		goToClientes.addPostBehavior(new PauseBehavior(5000));
//		chain.addStep(goToClientes);
//		
//		Step openSearchClientes = new Step("openSearchClientes", new AnchorComponent(driver, new Parameter("s_2_1_8_0_mb")));
//		openSearchClientes.addPostBehavior(new PauseBehavior(5000));
//		chain.addStep(openSearchClientes);
		chain.start();
		
		WebElement findElement = driver.findElement(By.id("s_a_1"));
		System.out.println(findElement);
	}
}
