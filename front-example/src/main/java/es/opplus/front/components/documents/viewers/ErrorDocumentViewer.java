package es.opplus.front.components.documents.viewers;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.IronIcon;

public class ErrorDocumentViewer extends DocumentViewer {

    public ErrorDocumentViewer() {
        this("");
    }
    public ErrorDocumentViewer(String msg) {

        this.setAlignItems(Alignment.CENTER);
        // this.setAlignSelf(Alignment.CENTER);
        this.getStyle().set("align-self", "center");

        IronIcon icon = FontAwesome.Solid.EXCLAMATION_TRIANGLE.create();
        icon.setSize("200px");
        icon.setColor("var(--lumo-error-color-50pct)");
        add(icon, new Label("Se ha producido un error al descargar en documento"));
        if (!msg.isEmpty()) add(new Label(msg));
    }
}
