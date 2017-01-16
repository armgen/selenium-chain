/**
 * 
 */
package br.com.armgen.commons.components;

import java.util.HashMap;

import org.openqa.selenium.By;

/**
 * @author leonardo.silva
 *
 */
public class Parameters {

	private final HashMap<String, Parameter> cached = new HashMap<String, Parameter>();
	
	public static class Parameter {
		
		private final String name;
		private String value;
		private String defaultValue;
		private By searchBy;
		
		public Parameter(String name, String value, String defaultValue) {
			this.name = name;
			this.value = value;
			this.defaultValue = defaultValue;
			this.searchBy = By.id(name);
		}
		
		public Parameter(String name, String value) {
			this(name, value, null);
		}
		
		/**
		 * Construtor para Parametros sem valor. Ex.: A, Buton
		 * @param name
		 */
		public Parameter(String name) {
			this(name, null);
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * @return the defaultValue
		 */
		public String getDefaultValue() {
			return defaultValue;
		}

		/**
		 * @param defaultValue the defaultValue to set
		 */
		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}

		/**
		 * @return the searchBy
		 */
		public By getSearchBy() {
			return searchBy;
		}

		/**
		 * @param searchBy the searchBy to set
		 */
		public void setSearchBy(By searchBy) {
			this.searchBy = searchBy;
		}
		
		public Parameter searchBy(By searchBy ) {
			this.setSearchBy(searchBy);
			return this;
		}
		
	}
	
	
	public void addParameter(String key, Parameter parameter) {
		this.cached.put(key, parameter);
	}
	
	public void addParameter(String key, String name, String value) {
		this.addParameter(key, name, value, null);
	}

	public void addParameter(String key, String name, String value, String defaultValue) {
		this.addParameter(key, new Parameter(name, value, defaultValue));
	}
	
	public Parameter getParameter(String key) {
		return this.cached.get(key);
	}
	
	public HashMap<String, Parameter> getAllParameters() {
		return this.cached;
	}

	public void addParameter(String key, String name) {
		this.addParameter(key, name, null);
	}

}
