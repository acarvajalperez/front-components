package es.opplus.front.components.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@JsModule("./theme/profesional/components/pro-drawer.js")
@JsModule("./theme/profesional/components/pro-navigation-bar.js")
public class NavigationBar extends HorizontalLayout {

    private Label titleComponent;

    public NavigationBar(Component logo, String titleString, Component... actions) {
        addClassName("nav-bar");

        this.titleComponent = new Label(titleString);
        this.titleComponent.setClassName("nav-bar-title");

        /*
        if (logo instanceof Image) {
            ((Image)logo).setClassName("nav-bar-logo-image");
        }
         */

        /*
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.addClassName("nav-bar-logo-layout");
        logoLayout.add(new DrawerToggle(), logo);
         */

        add(new DrawerToggle(), titleComponent);
        for (Component component : actions) {
            if (component instanceof Button)
                ((Button)component).addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            add(component);
        }
    }
    public void setTitleComponent(String titleComponent) {
        this.titleComponent.setText(titleComponent);
    }
}
