package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.opplus.front.components.cards.CardComponent;
import io.quarkus.oidc.RefreshToken;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Port of the "Skeleton Starter" Vaadin app on top of Quarkus+Undertow.
 *
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("view.inbox.debug")
@Route(value = "debug", layout = TasksInbox.class)
public class DebugView extends VerticalLayout implements AfterNavigationObserver {

    private final Logger logger = LoggerFactory.getLogger(DebugView.class);

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

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        FormLayout layout = new FormLayout();
        layout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("10em", 1),
                new FormLayout.ResponsiveStep("10em", 2),
                new FormLayout.ResponsiveStep("10em", 3)
        );

        TextField expirationDateField = new TextField("Expiration Date");
        expirationDateField.setReadOnly(true);

        TextField expirationDateField2 = new TextField("Expiration Date");
        expirationDateField2.setReadOnly(true);

        TextArea textArea = new TextArea("Token info");
        textArea.setWidthFull();
        textArea.setReadOnly(true);

        //textArea.setValue(jwt.toString());
        logger.info("Claims: " + jwt.getClaimNames());
        logger.info("Issuer: " + jwt.getIssuer());
        logger.info("Subject: " + jwt.getSubject());
        logger.info("Audience: " + jwt.getAudience());
        logger.info("Groups: " + jwt.getGroups());

        for (String claim : jwt.getClaimNames()) {
            textArea.setValue(textArea.getValue() + claim + ": " + jwt.getClaim(claim).toString() + System.lineSeparator() + System.lineSeparator());
            if (claim.equals("exp"))
                expirationDateField.setValue(jwt.getClaim(claim).toString());
            if (claim.equals("iat"))
                expirationDateField2.setValue(jwt.getClaim(claim).toString());

        }

        layout.add(expirationDateField, expirationDateField2);
        layout.add(textArea,3);
        add(new CardComponent(FontAwesome.Solid.CERTIFICATE.create(), description, layout));
    }
}
