package es.opplus.front.micro;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.WebComponentExporter;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.webcomponent.WebComponent;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;


//@NpmPackage(value = "micro-frontend", version = "^0.0.1")
//@JsModule("micro-frontend/src/micro-app-catalog.js")
@RouteAlias("")
@Route(value = "micro-app-catalog")
@CssImport("./micro-app-catalog.css")
public class AppCatalog extends Div {

    public static class Exporter extends WebComponentExporter<AppCatalog> {

        public Exporter() {
            super("micro-app-catalog");
            addProperty("selectedApp", "").onChange(
                    (appcatalog, appId) -> {
                        if ("".equals(appId))
                            return;
                        appcatalog.setApp(appId);
                    }
            );
        }

        @Override
        protected void configureInstance(WebComponent<AppCatalog> webComponent, AppCatalog component) {

        }
    }

    public AppCatalog() {
        super();
        setClassName("micro-app-catalog");
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create(), "Directorio"));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create(), "Catalogo de procesos"));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create(), "Picasso"));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create(), "Picasso"));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create(), "Picasso"));
        add(new ApplicationIndexButton(FontAwesome.Solid.ADDRESS_BOOK.create(), "Picasso"));
        add(new ApplicationIndexButton(new Image("./icons/address_book3.png", "AAA"), "Directorio"));
        add(new ApplicationIndexButton(new Image("./icons/address_book.png", "BBB"), "Directorio3"));
    }

    private void setApp(String appId) {
    }

}