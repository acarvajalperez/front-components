package es.opplus.front.micro;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ApplicationIndexButton extends VerticalLayout {

    public ApplicationIndexButton(IronIcon icon, String name) {
        icon.setSize("4em");
        this.setHeight("8em");

        Label label = new Label(name);
        label.setWidth("100%");

        this.add(icon);
        this.add(label);
        this.getStyle().set("justify-self", "center");
        this.getStyle().set("display", "grid");
        this.getStyle().set("border", "1px");
    }

    public ApplicationIndexButton(Image icon, String name) {
        this.setHeight("8em");

        icon.setHeight("4em");
        icon.setWidth("4em");

        Label label = new Label(name);
        label.setWidth("100%");

        this.add(icon);
        this.add(label);
        this.getStyle().set("justify-self", "center");
        this.getStyle().set("display", "grid");
        this.getStyle().set("border", "1px");
    }
}