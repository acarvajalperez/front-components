package es.opplus.front.components.documents.viewers;

import com.vaadin.flow.server.StreamResource;

public class PlainTextDocumentViewer extends DocumentViewer {

    public PlainTextDocumentViewer(StreamResource resource) {
        this.setSizeFull();
        this.getElement().setAttribute("type", "application/text");
        this.getElement().setAttribute("data", resource);
        /*
        TextArea textArea = new TextArea("", resource.);
        textArea.setSizeFull();
        add(textArea);
         */
    }
}
