/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import br.com.armgen.uta.sdk.element.*;
import br.com.armgen.uta.sdk.execution.action.*;
import org.junit.Test;

/**
 * @author leonardo.silva
 *
 */
public class SequenceChainTest {

	@Test
	public void testSuccessfullLoginChainTest() {
		Chain chain = Chains.sequence(SeleniumBrowser.basic());

		InputElement usernameField = new InputElement("j_username", By.NAME);
		Step fillUsername = Step.basic("Fill Username").action(new FillAction(usernameField, "71000000"));

		InputElement passwordField = new InputElement("j_password", By.NAME);
		Step fillPassword = Step.basic("Fill Password").action(new FillAction(passwordField, "claro#123"));

		InputElement submitField = new InputElement("button", By.NAME);

		InputElement readField = new InputElement("j_username", By.NAME);

		final StringBuilder campox = new StringBuilder();
		chain
				//1
				.step(Step.navigate("Login Page", "http://terbio.sysmap.com.br:5001/ativacao/login.jsp"))
				//2
				.step(fillUsername)
				//3
				.step(fillPassword)
				//4
				.step(Step.basic("Read Values").action(new CallbackAction(
						new CallbackAction.Callback() {
							@Override
							public void execute(Page page) {
								campox.append(readField.read(page,"value"));
							}
						}
						)))
				.step(Step.basic("Submit Login").action(new ClickAction(submitField)))
			    //5
			    //.step(Step.switchPage("Change to Popup",null))
				//6

		;
		// ;


		InputElement sellerField = new InputElement("seller", By.NAME);
		Step fillSeller = Step.basic("Fill Seller").action(new FillAction(sellerField, "cos11"));

		InputElement activityTypeField = new InputElement("seller", By.NAME);
		Step clickActivityType = Step.basic("Click activityTypeField").action(new ClickRadioAction(activityTypeField, 1));

		InputElement tipoPlanoField = new InputElement("tipoPlano", By.NAME);
		Step clickTipoPlano = Step.basic("Click tipoPlano").action(new ClickRadioAction(tipoPlanoField, 3));

		InputElement tipoTecnologiaField = new InputElement("tipoTecnologia", By.NAME);
		Step clickTipoTecnologia = Step.basic("Click tipoTecnologia").action(new ClickRadioAction(tipoTecnologiaField, 2));

		InputElement productTypeField = new InputElement("productType", By.NAME);
		Step clickProductType = Step.basic("Click productType").action(new ClickRadioAction(productTypeField, 4));

		ButtonElement abaDadosField = new ButtonElement("//*[@id=\"tab-pane-1\"]/div[1]/h2[2]/a", By.XPATH);
		Step clickAbaDados = Step.basic("Click Aba Dados").action(new ClickAction(abaDadosField));

		SelectElement tipoDePessoaField = new SelectElement("tipoDePessoa", By.NAME);
		Step selectTipoDePessoa = Step.basic("Select tipoDePessoa").action(new SelectAction(tipoDePessoaField, SelectableElement.SelectionType.BY_VISIBLE_TEXT, "Individual"));

		SelectElement subTipoDePessoaField = new SelectElement("subTipoDePessoa", By.NAME);
		Step selectSubTipoDePessoa = Step.basic("Select subTipoDePessoa").action(new SelectAction(subTipoDePessoaField, SelectableElement.SelectionType.BY_VISIBLE_TEXT, "Normal"));

		SelectElement codigoPaisField = new SelectElement("codigoPais", By.NAME);
		Step selectCodigoPais = Step.basic("Select codigoPais").action(new SelectAction(codigoPaisField, SelectableElement.SelectionType.BY_VISIBLE_TEXT, "Brasil"));

		InputElement txtNomeField = new InputElement("txtNome", By.NAME);
		Step fillTxtNome = Step.basic("Fill txtNome").action(new FillAction(txtNomeField, "Jose da Silva"));

		InputElement cpfField = new InputElement("cpf", By.NAME);
		Step fillCpf = Step.basic("Fill cpf").action(new FillAction(cpfField, "00000000191"));

		InputElement residentialZipCodeField = new InputElement("residentialZipCode", By.NAME);
		Step fillResidentialZipCode = Step.basic("Fill residentialZipCode").action(new FillAction(residentialZipCodeField, "18550000"));

		InputElement birthdayField = new InputElement("birthday", By.NAME);
		Step fillBirthday = Step.basic("Fill birthday").action(new FillAction(birthdayField, "10/10/1980"));

		InputElement genderField = new InputElement("gender", By.NAME);
		Step clickGender = Step.basic("Click gender").action(new ClickRadioAction(genderField, 1));

		InputElement customerMotherNameField = new InputElement("customerMotherName", By.NAME);
		Step fillCustomerMotherName = Step.basic("Fill customerMotherName").action(new FillAction(customerMotherNameField, "Mae Mae"));

		SelectElement maritalStatusField = new SelectElement("maritalStatus", By.NAME);
		Step selectMaritalStatus = Step.basic("Select maritalStatus").action(new SelectAction(maritalStatusField, SelectableElement.SelectionType.BY_VISIBLE_TEXT, "Casada(o)"));

		SelectElement occupationField = new SelectElement("occupation", By.NAME);
		Step selectOccupation = Step.basic("Select occupation").action(new SelectAction(occupationField, SelectableElement.SelectionType.BY_VISIBLE_TEXT, "Empresario"));

		SelectElement wageRangeField = new SelectElement("wageRange", By.NAME);
		Step selectWageRange = Step.basic("Select wageRange").action(new SelectAction(wageRangeField, SelectableElement.SelectionType.BY_VISIBLE_TEXT, "Ate R$500,00"));

		InputElement dddField = new InputElement("ddd", By.NAME);
		Step fillDDD = Step.basic("Fill ddd").action(new FillAction(dddField, "11"));

		ButtonElement btnSimulateDKField = new ButtonElement("btnSimulateDK", By.NAME);
		Step clickBtnSimulateDK = Step.basic("Click btnSimulateDK").action(new ClickAction(btnSimulateDKField));

		chain
				.step(fillSeller)
				.step(clickActivityType)
				.step(clickTipoPlano)
				.step(clickTipoTecnologia)
				.step(clickProductType)
				.step(clickAbaDados)
				.step(selectTipoDePessoa)
				.step(selectSubTipoDePessoa)
				.step(selectCodigoPais)
				.step(fillTxtNome)
				.step(fillCpf)
				.step(fillResidentialZipCode)
				.step(fillBirthday)
				.step(clickGender)
				.step(fillCustomerMotherName)
				.step(selectMaritalStatus)
				.step(selectOccupation)
				.step(selectWageRange)
				.step(fillDDD)
				.step(clickBtnSimulateDK);

		chain.start();

		System.out.println(campox.toString());
	}

}
