package es.opplus.app.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import es.opplus.front.views.TasksInbox;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;

/**
 * Port of the "Skeleton Starter" Vaadin app on top of Quarkus+Undertow.
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("view.inbox.global")
@Route(value = "inbox-global", layout = TasksInbox.class)
public class GlobalInboxView extends VerticalLayout {

    public GlobalInboxView() {
        IronIcon icon =  FontAwesome.Solid.ENVELOPE.create();
        icon.setSize("100px");
        icon.setColor("red");
        add(icon);
        add(new Span("Hola"));
    }
}
