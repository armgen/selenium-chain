/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import org.junit.Test;

import br.com.armgen.uta.sdk.element.InputElement;
import br.com.armgen.uta.sdk.execution.action.ClickAction;
import br.com.armgen.uta.sdk.execution.action.FillAction;

/**
 * @author leonardo.silva
 *
 */
public class SequenceChainTest {

	@Test
	public void testSuccessfullLoginChainTest() {
		Chain chain = Chains.sequence(SeleniumBrowser.basic());
		
		InputElement usernameField = new InputElement("j_username", By.ID);
		Step fillUsername = Step.basic("Fill Username").action(new FillAction(usernameField, "pedrofolim"));
		
		InputElement passwordField = new InputElement("j_password", By.ID);
		Step fillPassword = Step.basic("Fill Password").action(new FillAction(passwordField, "pedrofolim"));
		
		InputElement submitField = new InputElement("submit", By.ID);
		
		chain
			//1
			.step(Step.navigate("Login Page", "http://sistema/login"))
			//2
			.step(fillUsername)
			//3
			.step(fillPassword)
			//4
			.step(Step.basic("Submit Login").action(new ClickAction(submitField)))
			//5
			.step(Step.switchPage("Change to Popup",null));
			;
	}

}
