package es.opplus.app;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.server.PWA;
import es.opplus.app.enlace1.Enlace1;
import es.opplus.app.enlace2.Enlace2;
import es.opplus.front.components.layout.OpplusLayout;

@PWA(name = "Opplus Template", shortName = "Opplus template", enableInstallPrompt = false)
public class TasksInbox extends OpplusLayout {
    @Override
    protected Component[] createMenuItems() {
        return new Tab[]{
                this.createMenuItem(FontAwesome.Solid.INBOX.create(), "Ejemplo de enlace 1", new Label("132"), Enlace1.class),
                this.createMenuItem(FontAwesome.Solid.INBOX.create(), "Ejemplo de enlace 2", null, Enlace2.class)
        };
    }
}
