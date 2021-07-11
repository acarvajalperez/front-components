package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.opplus.front.components.layout.OpplusLayout;


import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;


@Tag("micro-app-catalog")
public class AppCatalogRemote extends Component {

    public AppCatalogRemote() {
        //add(new AppCatalog());
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        System.out.println("****************** enganchando ******************");
        attachEvent.getUI().getPage().executeJs(
                "var s = document.createElement('script');s.type='module'; s.src=$0;document.head.appendChild(s);",
                //"/front-micro-app-catalog/web-component/micro-app-catalog.js");
                "http://localhost:8889/web-component/micro-app-catalog.js");
    }

    public void setApp(String appId) {
        getElement().setProperty("appId", appId);
    }
}
