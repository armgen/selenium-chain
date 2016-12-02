/**
 * 
 */
package br.com.armgen.commons.elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import lombok.Data;

/**
 * @author leonardo.silva
 *
 */
@Data
public class Page {
	
	/**
	 * Links encontrados na pagina
	 */
	private final List<Link> links = new ArrayList<Link>();
	/**
	 * Forms encontrados na pagina
	 */
	private final  List<Form> forms = new ArrayList<Form>();
	
	protected final WebDriver driver;
	protected final String url;
	
	public void init() {
		this.driver.get(getUrl());
	}
	
}
