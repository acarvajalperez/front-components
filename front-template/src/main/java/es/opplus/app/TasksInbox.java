package es.opplus.app;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.tabs.Tab;
import es.opplus.app.enlace1.Enlace1;
import es.opplus.app.enlace2.Enlace2;
import es.opplus.front.components.layout.OpplusLayout;

@PWA(name = "Opplus Template", shortName = "Opplus template", enableInstallPrompt = false)
@CssImport("./styles/views/main/main-view.css")
@JsModule("./styles/shared-styles.js")
@StyleSheet("https://fonts.googleapis.com/css?family=Montserrat")
public class TasksInbox extends OpplusLayout {
    @Override
    protected Component[] createMenuItems() {
        return new Tab[]{
                createTab(FontAwesome.Solid.INBOX.create(), "Ejemplo de enlace 1", new Label("132"), Enlace1.class),
                createTab(FontAwesome.Solid.INBOX.create(), "Ejemplo de enlace 2", null, Enlace2.class)
        };
    }
}
