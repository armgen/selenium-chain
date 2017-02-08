/**
 * 
 */
package br.com.armgen.uta.sdk.element;

import br.com.armgen.uta.sdk.element.object.Table;
import br.com.armgen.uta.sdk.element.object.Td;
import br.com.armgen.uta.sdk.element.object.Tr;
import br.com.armgen.uta.sdk.execution.By;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author pedro.folim
 *
 */
public class TableElement extends Element implements ReadableElement<Table> {

	/**
	 *
	 * @param identifier
	 * @param searchBy
	 */
	public TableElement(String identifier, By searchBy) {
		super(identifier, searchBy);
	}


	@Override
	public Table read(Page page, String attributeName) {

		SeleniumPage seleniumPage = (SeleniumPage) page;
		WebElement element = seleniumPage.getElement(this);

		if(element == null) throw new IllegalStateException("element can not be empty for the read");

		Table table = new Table();

		if(!element.getAttribute("innerHTML").contains("<tr"))return null;
		List<WebElement> tr_collection = element.findElements(org.openqa.selenium.By.xpath(".//tbody/tr"));
		for(WebElement trElement : tr_collection) {
			//TODO ARRUMAR ISSO DEPOIS DA POC
			if(trElement.getAttribute("innerHTML").contains("<table"))continue;
			if(trElement.getAttribute("innerHTML").contains("(Tramitação prioritária)"))continue;
			if(trElement.getAttribute("innerHTML").contains("Local Físico:"))continue;
			if(trElement.getAttribute("innerHTML").contains("Outros assuntos:"))continue;
			List<WebElement> td_collection = trElement.findElements(org.openqa.selenium.By.xpath(".//td"));
			Tr tr = new Tr();
			for(WebElement tdElement : td_collection){
				if(tdElement.getAttribute("innerHTML").contains("<table"))continue;
				tr.getTds().add(new Td(tdElement.getText()));
			}
			table.getTrs().add(tr);
		}

		return table;
	}

	@Override
	public String getText(Page page) {
		return null;
	}
}
