package com.demoqa.elements;

import com.codeborne.selenide.SelenideElement;

public class Input {

    private final String name;
    private final SelenideElement selector;

    public Input(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }


    public void setValue(String value){
        System.out.println("Ввести в инпут " + name + " значение " + value);
        selector.setValue(value);
    }

    public void clear() {
        System.out.println("очистить инпут " + name);
    }
}
