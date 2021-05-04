package es.opplus.front.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;

/**
 * Port of the "Skeleton Starter" Vaadin app on top of Quarkus+Undertow.
 *
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("view.inbox.debug")
@Route(value = "debug", layout = TasksInbox.class)
@Authenticated
public class DebugView extends VerticalLayout implements AfterNavigationObserver {

    @Inject
    JsonWebToken jwt;

    TextArea textAreaJwtToken;
    TextArea textAreaVaadinSession;

    public DebugView() {
        textAreaJwtToken = new TextArea("Json Web Token:");
        textAreaJwtToken.setWidthFull();
        textAreaJwtToken.setReadOnly(true);

        textAreaVaadinSession = new TextArea("Vaadin Session:");
        textAreaVaadinSession.setWidthFull();
        textAreaVaadinSession.setReadOnly(true);

        add(textAreaVaadinSession, textAreaJwtToken);
        //grid = new Grid<>;

    }

    /**
     * Callback executed after navigation has been executed.
     *
     * @param event after navigation event with event details
     */
    @Override
    public void afterNavigation(AfterNavigationEvent event) {

        textAreaVaadinSession.setValue(
                "State: " + UI.getCurrent().getSession().getState().toString() + System.lineSeparator() +
                "PushId: " + UI.getCurrent().getSession().getPushId() + System.lineSeparator() +
                "Last Request Duration: " + UI.getCurrent().getSession().getLastRequestDuration() + System.lineSeparator() +
                "Last Request Timestamp: " + UI.getCurrent().getSession().getLastRequestTimestamp() + System.lineSeparator() +
                "Locale: " + UI.getCurrent().getSession().getLocale().toString()
        );

        textAreaJwtToken.setValue(jwt.toString());
        add(new TextField("Preferred username", jwt.getClaim("preferred_username").toString()));
        System.out.println("Claims: " + jwt.getClaimNames());
        System.out.println("Issuer: " + jwt.getIssuer());
        System.out.println("Subject: " + jwt.getSubject());
        System.out.println("Audience: " + jwt.getAudience());
        System.out.println("Groups: " + jwt.getGroups());

        for (String claim : jwt.getClaimNames()) {
            textAreaJwtToken.setValue(textAreaJwtToken.getValue() + claim + ": " + jwt.getClaim(claim).toString() + System.lineSeparator() + System.lineSeparator());
        }
    }
}
