package es.opplus.front.components.documents.viewers;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.server.StreamResource;

@Tag("object")
public class PdfDocumentViewer extends DocumentViewer {
    public PdfDocumentViewer(StreamResource resource) {
        this.setId("pdf-document-viewer");
        this.setSizeFull();
        this.getElement().setAttribute("type", "application/pdf");
        this.getElement().setAttribute("data", resource);
    }
}
