package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.opplus.front.components.cards.CardComponent;
import io.quarkus.oidc.RefreshToken;
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
public class DebugView extends VerticalLayout implements AfterNavigationObserver {

    /**
     * Injection point for the ID Token issued by the OpenID Connect Provider
     */
    @Inject
    JsonWebToken idToken;

    /**
     * Injection point for the Access Token issued by the OpenID Connect Provider
     */
    @Inject
    JsonWebToken accessToken;

    /**
     * Injection point for the Refresh Token issued by the OpenID Connect Provider
     */
    @Inject
    RefreshToken refreshToken;

    TextArea textAreaJwtToken;
    TextArea textAreaVaadinSession;

    public DebugView() {
        textAreaVaadinSession = new TextArea();
        textAreaVaadinSession.setWidthFull();

        add(new CardComponent(FontAwesome.Solid.CERTIFICATE.create(), "Vaadin Session", textAreaVaadinSession));
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
        showTokenInfo("ID Token", idToken);
        showTokenInfo("Access Token", accessToken);
        //showTokenInfo();
        //add(refreshToken.getToken());
    }

    public void showTokenInfo(String description, JsonWebToken jwt)  {
        TextArea textArea = new TextArea();
        textArea = new TextArea();
        textArea.setWidthFull();
        //textArea.setReadOnly(true);

        textArea.setValue(jwt.toString());
        System.out.println("Claims: " + jwt.getClaimNames());
        System.out.println("Issuer: " + jwt.getIssuer());
        System.out.println("Subject: " + jwt.getSubject());
        System.out.println("Audience: " + jwt.getAudience());
        System.out.println("Groups: " + jwt.getGroups());

        for (String claim : jwt.getClaimNames()) {
            textArea.setValue(textArea.getValue() + claim + ": " + jwt.getClaim(claim).toString() + System.lineSeparator() + System.lineSeparator());
        }
        add(new CardComponent(FontAwesome.Solid.CERTIFICATE.create(), description, textArea));
    }
}
