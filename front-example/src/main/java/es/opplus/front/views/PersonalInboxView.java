package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.opplus.front.views.TasksInbox;

/**
 * A very simple demo route, demoes the ability of Quarkus+Undertow to discover
 * all routes on the classpath.
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("view.inbox.personal")
@Route(value = "inbox-personal", layout = TasksInbox.class)
public class PersonalInboxView extends VerticalLayout {
    public PersonalInboxView() {
        IronIcon icon =  FontAwesome.Solid.ENVELOPE.create();
        icon.setSize("50%");
        icon.setColor("pink");
        this.setHeightFull();
        this.setAlignItems(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.CENTER);
        add(icon);
    }
}
