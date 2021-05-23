package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import es.opplus.front.components.layout.OpplusLayout;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import java.util.Locale;

@PWA(name = "Tasks inbox", shortName = "Tasks inbox", enableInstallPrompt = true)
@CssImport("./styles/views/main/main-view.css")
@JsModule("./styles/shared-styles.js")
@Route(value = "")
public class TasksInbox extends OpplusLayout implements AfterNavigationObserver {

    @Inject
    JsonWebToken jwt;

    public TasksInbox() {
        addAction(FontAwesome.Solid.TOOLBOX.create(), e -> {
            UI.getCurrent().navigate(ApplicationIndexView.class);
        });
        addAction(FontAwesome.Solid.BELL.create(), e -> {
            UI.getCurrent().navigate(ApplicationIndexView.class);
        });
        addAction(FontAwesome.Solid.TH.create(), e -> {
            UI.getCurrent().navigate(ApplicationIndexView.class);
        });
    }

    public void addAction(IronIcon icon, ComponentEventListener<ClickEvent<Button>> listener) {
        icon.setColor("white");
        icon.setSize("20px");
        Button button = new Button(icon, listener);
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        this.getNavigationBar().add(button);
    }

    @Override
    protected Component[] createMenuItems() {
        Button button = new Button("1324");
        button.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_TERTIARY_INLINE);
        return new Tab[]{
                createMenuItem(FontAwesome.Solid.INBOX.create(), "Pendientes", button, GlobalInboxView.class),
                createMenuItem(FontAwesome.Solid.INBOX.create(), "Personal", button, PersonalInboxView.class),
                createMenuItem(FontAwesome.Solid.DOWNLOAD.create(), "Operaciones", null, OperationsView.class),
                createMenuItem(FontAwesome.Solid.COG.create(), "Services", null, ServicesView.class),
                createMenuItem(FontAwesome.Solid.BUG.create(), "Debug", null, DebugView.class),
                createMenuItem(FontAwesome.Solid.ROBOT.create(), "Robots", null, RobotView.class)
        };
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        if (jwt.getClaim("name") != null) {
            getNavigationBar().setAvatar(
                    new Avatar(
                            jwt.getClaim("name").toString().toUpperCase(Locale.ROOT)
                    )
            );
        }
    }
}
