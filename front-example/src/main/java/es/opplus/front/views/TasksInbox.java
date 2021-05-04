package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinSession;
import es.opplus.front.views.GlobalInboxView;
import es.opplus.front.views.OperationsView;
import es.opplus.front.views.PersonalInboxView;
import es.opplus.front.components.layout.OpplusAvatar;
import es.opplus.front.components.layout.OpplusLayout;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import java.util.Locale;

@PWA(name = "Opplus Template", shortName = "Opplus template", enableInstallPrompt = false)
@CssImport("./styles/views/main/main-view.css")
@JsModule("./styles/shared-styles.js")
@StyleSheet("https://fonts.googleapis.com/css2?family=Manjari:wght@700&display=swap")
@Route(value = "")
public class TasksInbox extends OpplusLayout implements AfterNavigationObserver {

    @Override
    protected Component[] createMenuItems() {
        Button button = new Button("1324");
        button.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_TERTIARY_INLINE);
        return new Tab[]{
                createMenuItem(FontAwesome.Solid.INBOX.create(), "Pendientes", button, GlobalInboxView.class),
                createMenuItem(FontAwesome.Solid.INBOX.create(), "Personal", button, PersonalInboxView.class),
                createMenuItem(FontAwesome.Solid.DOWNLOAD.create(), "Operaciones", null, OperationsView.class),
                createMenuItem(FontAwesome.Solid.DOWNLOAD.create(), "Operaciones", null, ServiceInterfacesRoute.class),
                createMenuItem(FontAwesome.Solid.BUG.create(), "Debug", null, DebugView.class)
        };
    }

    @Inject
    JsonWebToken jwt;

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        getNavigationBar().setAvatar(new Avatar(
                jwt.getClaim("name").toString().toUpperCase(Locale.ROOT))
        );
    }
}
