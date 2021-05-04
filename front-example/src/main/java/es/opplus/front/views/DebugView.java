package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import java.util.Locale;

/**
 * Port of the "Skeleton Starter" Vaadin app on top of Quarkus+Undertow.
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("view.inbox.debug")
@Route(value = "debug", layout = TasksInbox.class)
public class DebugView extends VerticalLayout implements AfterNavigationObserver {

    @Inject
    JsonWebToken jwt;

    TextArea textArea;

    public DebugView() {
        textArea = new TextArea("JsonWebToken:");
        textArea.setWidthFull();
        textArea.setReadOnly(true);
        add (textArea);
        //grid = new Grid<>;

    }

    /**
     * Callback executed after navigation has been executed.
     *
     * @param event after navigation event with event details
     */
    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        textArea.setValue(jwt.toString());
        add (new TextField("Preferred username", jwt.getClaim("preferred_username").toString()));
        System.out.println("Claims: " + jwt.getClaimNames());
        System.out.println("Issuer: " + jwt.getIssuer());
        System.out.println("Subject: " + jwt.getSubject());
        System.out.println("Audience: " + jwt.getAudience());
        System.out.println("Groups: " + jwt.getGroups());

        for (String claim : jwt.getClaimNames()) {
            textArea.setValue(textArea.getValue() + claim + ": " + jwt.getClaim(claim).toString() + System.lineSeparator() + System.lineSeparator());
        }
    }
}
