package es.opplus.front.components.documents.viewers;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.IronIcon;

public class NoDocumentViewer extends DocumentViewer {
    public NoDocumentViewer() {
        this.setAlignItems(Alignment.CENTER);
        this.getStyle().set("align-self", "center");

        IronIcon icon = FontAwesome.Solid.FILE_ALT.create();
        icon.setSize("200px");
        icon.setColor("var(--lumo-contrast-50pct)");
        add(icon, new Label("Selecciona un documento"));
    }
}
