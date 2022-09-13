package com.demoqa.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class RadioButton {

    private final String name;
    private final SelenideElement selector;

    public RadioButton(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }


    public void setElement(String value) {
        System.out.println("Выбрать значение " + value +  " в радиобаттоне " + name);
        selector.$(byText(value)).click();
    }


}
