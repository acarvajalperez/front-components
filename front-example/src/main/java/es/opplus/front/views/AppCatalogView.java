package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.opplus.front.components.layout.OpplusLayout;

@PageTitle("view.inbox.appindex")
@Route(value = "app-index", layout = OpplusLayout.class)
public class AppCatalogView extends Div {
    public AppCatalogView() {
        add(new Label("Microcomponente"));
        add(new AppCatalogRemote());
    }
}
