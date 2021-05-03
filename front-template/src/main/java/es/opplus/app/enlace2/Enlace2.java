package es.opplus.app.enlace2;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.opplus.app.TasksInbox;

/**
 * A very simple demo route, demoes the ability of Quarkus+Undertow to discover
 * all routes on the classpath.
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("View 2")
@Route(value = "view2", layout = TasksInbox.class)
public class Enlace2 extends VerticalLayout {
    public Enlace2() {
        IronIcon icon =  FontAwesome.Solid.ENVELOPE.create();
        icon.setSize("50%");
        icon.setColor("pink");
        this.setHeightFull();
        this.setAlignItems(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.CENTER);
        add(icon);
    }
}
