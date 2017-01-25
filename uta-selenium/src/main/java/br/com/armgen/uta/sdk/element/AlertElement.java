package br.com.armgen.uta.sdk.element;

import br.com.armgen.uta.sdk.execution.By;

/**
 * Created by Pedro on 25/01/2017.
 */
public class AlertElement implements AlertableElement {

    @Override
    public void accept(Page page) {
        SeleniumPage seleniumPage = (SeleniumPage) page;
        seleniumPage.getDriver().switchTo().alert().accept();
    }
}
