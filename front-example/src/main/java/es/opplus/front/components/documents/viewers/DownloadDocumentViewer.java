package es.opplus.front.components.documents.viewers;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.IronIcon;

public class DownloadDocumentViewer extends DocumentViewer {
    public DownloadDocumentViewer() {

        this.setAlignItems(Alignment.CENTER);
        //this.setAlignSelf(Alignment.CENTER);
        this.getStyle().set("align-self", "center");

        IronIcon icon = FontAwesome.Solid.DOWNLOAD.create();
        icon.setSize("200px");
        icon.setColor("var(--lumo-success-color-50pct)");
        add(icon);
        add(new Label("Este documento no puede visualizarse"));
        add(new Label("Pulsa aquí para descargar el documento"));
    }
}
