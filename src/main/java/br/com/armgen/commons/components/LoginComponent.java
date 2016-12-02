/**
 * 
 */
package br.com.armgen.commons.components;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.armgen.commons.components.Parameters.Parameter;
import br.com.armgen.commons.elements.Button;
import br.com.armgen.commons.elements.Form;
import br.com.armgen.commons.elements.Page;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leonardo.silva
 *
 */
@Slf4j
public class LoginComponent extends BaseComponents implements Component {

	private final Parameters parameters;
	private final LoginPage loginPage;

	private class LoginPage extends Page {

		public LoginPage(WebDriver driver, String url) {
			super(driver, url);
			initializeFormLogin();
		}

		private void initializeFormLogin() {
			Form form = new Form() {

				protected Button getSubmitButton() {
					//Submit 
					Parameter submit = parameters.getParameter("submit");
					return new Button(getDriver(), submit);
				}

				protected Page getPageAfterSubmit() {
					return null;
				}

				protected void fill() {
					//					WebDriverWait wait = new WebDriverWait(driver, 30);
					init();

					//Username
					Parameter username = parameters.getParameter("username");
					//					wait.until(ExpectedConditions.presenceOfElementLocated( username.getSearchBy() ));
					log.info("Preenchendo campo de usuario com o valor {}", username.getValue());
					WebElement usernameField = driver.findElement(username.getSearchBy());
					usernameField.clear();
					usernameField.sendKeys(StringUtils.isNotBlank(username.getValue()) ? username.getValue() : username.getDefaultValue());

					//Password
					Parameter password = parameters.getParameter("password");
					log.info("Preenchendo campo de senha...");
					WebElement passwordField = driver.findElement(password.getSearchBy());
					passwordField.clear();
					passwordField.sendKeys(StringUtils.isNotBlank(password.getValue()) ? password.getValue() : password.getDefaultValue());
				}
			};
			this.getForms().add(form);
		}

	}

	public LoginComponent(WebDriver driver, String url, Parameters parameters) {
		super(driver);
		this.parameters = parameters;
		this.loginPage = new LoginPage(driver, url);
	}

	@Override
	protected void executeInternal(Parameters parameters) {
		Form form = this.loginPage.getForms().get(0);
		form.submit();
	}

}
