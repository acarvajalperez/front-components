package es.opplus.app.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.server.PWA;
import es.opplus.app.views.GlobalInboxView;
import es.opplus.app.views.OperationsView;
import es.opplus.app.views.PersonalInboxView;
import es.opplus.front.components.layout.OpplusLayout;

@PWA(name = "Opplus Template", shortName = "Opplus template", enableInstallPrompt = false)
@CssImport("./styles/views/main/main-view.css")
@JsModule("./styles/shared-styles.js")
@StyleSheet("https://fonts.googleapis.com/css2?family=Manjari:wght@700&display=swap")
public class TasksInbox extends OpplusLayout {
    @Override
    protected Component[] createMenuItems() {
        return new Tab[]{
                createMenuItem(FontAwesome.Solid.INBOX.create(), "Pendientes", new Label("132"), GlobalInboxView.class),
                createMenuItem(FontAwesome.Solid.INBOX.create(), "Personal", new Label("99"), PersonalInboxView.class),
                createMenuItem(FontAwesome.Solid.DOWNLOAD.create(), "Operaciones", null, OperationsView.class),
                createMenuItem(FontAwesome.Solid.DOWNLOAD.create(), "Operaciones", null, ServiceInterfacesRoute.class)
        };
    }
}
