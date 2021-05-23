package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.opplus.front.components.layout.OpplusLayout;

@PageTitle("view.inbox.appindex")
@Route(value = "app-index", layout = OpplusLayout.class)
public class ApplicationIndexView extends Div {

    class ApplicationIndexButton extends VerticalLayout {
        public ApplicationIndexButton(IronIcon icon) {
            icon.setSize("5em");
            this.setHeight("8em");

            Label label = new Label("Picasso");
            label.setWidth("100%");

            this.add(icon, label);
            this.getStyle().set("justify-self", "center");
            this.getStyle().set("display", "grid");
        }
    }

    public ApplicationIndexView() {
        this.getStyle().set("padding", "5em");
        this.getStyle().set("display", "grid");
        this.getStyle().set("justify-content", "center");
        this.getStyle().set("grid-template-columns", "150px 150px 150px 150px");
        this.getStyle().set("grid-template-rows", "150px 150px 150px");
        this.getStyle().set("column-gap", "15px");
        this.getStyle().set("row-gap", "15px");
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create()));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create()));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create()));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create()));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create()));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create()));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create()));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create()));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create()));
    }
}
