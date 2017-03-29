package br.com.armgen.uta.sdk.element;

import br.com.armgen.uta.sdk.execution.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author pedro.folim
 */
public class Select2Element extends Element implements SelectableElement{

    /**
     *
     * @param identifier
     * @param searchBy
     */
    public Select2Element(String identifier, By searchBy) {
        super(identifier, searchBy);
    }

    @Override
    public void selectValue(Page page, SelectionType selectionType, String value) {
        SeleniumPage seleniumPage = (SeleniumPage) page;
        WebElement element = seleniumPage.getElement(this);
        if(element == null) throw new IllegalStateException("Element can not be empty for the select2");

        seleniumPage.waitUntil(ExpectedConditions::visibilityOfElementLocated, this);
        executeJS(seleniumPage.getDriver(), "var value = $(\"" + this.getIdentifier() + "+select\").find('option:contains(\"" + value + "\")').val();" +
                "$(\"" + this.getIdentifier() + "\").select2(\"val\", value);");
    }

    private Object executeJS(WebDriver driver, final String script) {
        return ((JavascriptExecutor) driver).executeScript(script);
    }
}
