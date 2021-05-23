package es.opplus.front.components.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class NavigationBar extends HorizontalLayout {

    private Label   titleComponent;
    private Avatar  avatar;
    private Button  appIndex;

    public NavigationBar(Component logo, String titleString, Component... actions) {
        addClassName("nav-bar");

        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.addClassName("nav-bar-logo-layout");

        // Add DrawerToggle
        logoLayout.add(new DrawerToggle());

        // Add logo
        if (logo instanceof Image) {
            ((Image)logo).setClassName("nav-bar-logo-image");
        }
        logoLayout.add(logo);
        add(logoLayout);

        // Add title
        this.titleComponent = new Label(titleString);
        this.titleComponent.setClassName("nav-bar-title");
        this.setHeight("50px");
        add(titleComponent);

        // Add actions
        for (Component component : actions) {
            if (component instanceof Button)
                ((Button) component).addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            add(component);
        }
    }

    public NavigationBar(Component logo, String titleString, Avatar avatar, Component... actions) {
        this(logo,titleString,actions);

        // Add avatar
        this.avatar = avatar;
        add(new Button("hola"), avatar);
    }

    public void setTitleComponent(String titleComponent) {
        this.titleComponent.setText(titleComponent);
    }

    public void setAvatar(Avatar avatar) {
        if (this.avatar != null)
            this.replace(this.avatar, avatar);
        else
            this.add(avatar);
        this.avatar = avatar;
    }
}
