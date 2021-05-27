package es.opplus.front.micro.barcodescanner;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;

@Tag("micro-barcode-scanner")
@NpmPackage(value = "micro-frontend", version = "^0.0.1")
@JsModule("micro-frontend/src/micro-barcode-scanner.js")
public class BarcodesScanner extends Component implements HasComponents {

    private Div titleDiv;

    public BarcodesScanner(String title) {
        titleDiv = new Div();
        addToSlot("title", titleDiv);
        setTitle(title);
    }

    public void setTitle(String title) {
        titleDiv.setText(title);
    }

    public void addToSlot(String slot, Component component) {
        component.getElement().setAttribute("slot", slot);
        add(component);
    }
}